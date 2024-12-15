package com.ducpq.demo.myspringbootapp.rest;

import com.ducpq.demo.myspringbootapp.entity.Employee;
import com.ducpq.demo.myspringbootapp.exception.EmployeeNotFoundException;
import com.ducpq.demo.myspringbootapp.exception.RequiredFieldsNotMeetException;
import com.ducpq.demo.myspringbootapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeRestController {
	private final EmployeeService employeeService;
	
	// expose "/employees" and return a list of employees
	@GetMapping("")
	public List<Employee> findAll(
			@PageableDefault(size = 10)
			@SortDefault(sort = "id", direction = Sort.Direction.ASC)
			Pageable pageable) {
		return employeeService.findAll(pageable);
	}
	
	@GetMapping("/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		return employeeService.findById(employeeId);
	}
	
	@PostMapping("")
	public Employee addEmployee(@RequestBody Employee employee) {
		if (employee.getFirstName() == null || employee.getLastName() == null || employee.getEmail() == null) {
			throw new RequiredFieldsNotMeetException("Data is missing for: " + Employee.class.getName());
		}
		// In case user passing an id in JSON, set it into 0 to create new Employee
		employee.setId(0);
		return employeeService.save(employee);
	}
	
	@PutMapping("")
	public Employee updateEmployee(@RequestBody Employee employee) {
		if (employee.getId() == null || employee.getFirstName() == null || employee.getLastName() == null || employee.getEmail() == null) {
			throw new RequiredFieldsNotMeetException("Data is missing for: " + Employee.class.getName());
		}
		return employeeService.save(employee);
	}
	
	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee not found - " + employeeId);
		} else {
			employeeService.deleteById(employeeId);
			return "Deleted employee with id " + employeeId;
		}
	}
}
