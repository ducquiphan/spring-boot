package com.ducpq.demo.myspringbootapp.rest;

import com.ducpq.demo.myspringbootapp.entity.Employee;
import com.ducpq.demo.myspringbootapp.exception.RequiredFieldsNotMeetException;
import com.ducpq.demo.myspringbootapp.playload.response.RestResponse;
import com.ducpq.demo.myspringbootapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeRestController {
	private final EmployeeService employeeService;
	
	// expose "/employees" and return a list of employees
	@GetMapping("")
	public ResponseEntity<RestResponse<?>> findAll(
			@PageableDefault(size = 10)
			@SortDefault(sort = "id", direction = Sort.Direction.ASC)
			Pageable pageable) {
		return ResponseEntity.ok(employeeService.findAll(pageable));
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<?> findById(@PathVariable int employeeId) {
		return ResponseEntity.ok(employeeService.findById(employeeId));
	}
	
	@PostMapping("")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		if (employee.getFirstName() == null || employee.getLastName() == null || employee.getEmail() == null) {
			throw new RequiredFieldsNotMeetException("Data is missing for: " + Employee.class.getName());
		}
		// In case user passing an id in JSON, set it into 0 to create new Employee
		employee.setId(0);
		return ResponseEntity.ok(employeeService.save(employee));
	}
	
	@PutMapping("")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.save(employee));
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteById(employeeId);
		return ResponseEntity.ok("Deleted employee with id " + employeeId);
	}
}
