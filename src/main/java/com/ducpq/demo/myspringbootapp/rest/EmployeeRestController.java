package com.ducpq.demo.myspringbootapp.rest;

import com.ducpq.demo.myspringbootapp.entity.Employee;
import com.ducpq.demo.myspringbootapp.exception.EmployeeNotFoundException;
import com.ducpq.demo.myspringbootapp.exception.RequiredFieldsNotMeetException;
import com.ducpq.demo.myspringbootapp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	private final EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	// expose "/employees" and return a list of employees
	@GetMapping("")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee not found - " + employeeId);
		}
		return employee;
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
