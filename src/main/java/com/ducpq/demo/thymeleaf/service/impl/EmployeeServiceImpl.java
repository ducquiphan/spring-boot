package com.ducpq.demo.thymeleaf.service.impl;

import com.ducpq.demo.thymeleaf.entity.Employee;
import com.ducpq.demo.thymeleaf.exception.EmployeeNotFoundException;
import com.ducpq.demo.thymeleaf.exception.RequiredFieldsNotMeetException;
import com.ducpq.demo.thymeleaf.playload.response.ListResponse;
import com.ducpq.demo.thymeleaf.playload.response.RestResponse;
import com.ducpq.demo.thymeleaf.repository.EmployeeRepo;
import com.ducpq.demo.thymeleaf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepo employeeRepo;
	
	@Override
	public RestResponse<ListResponse<Employee>> findAll(Pageable pageable) {
		Page<Employee> pageResponse = employeeRepo.findAll(pageable);
		//		List<Employee> listEmployees = pageResponse.stream().toList(); // This way is slower due to converting it into stream
		List<Employee> listEmployees = pageResponse.getContent(); // This way is faster
		return RestResponse.ok(
				"200",
				"Find all employee successful!",
				ListResponse.build(pageResponse.getTotalPages(), listEmployees.size(), listEmployees));
	}
	
	@Override
	public RestResponse<Employee> findById(int id) {
		Optional<Employee> result = employeeRepo.findById(id);
		Employee employee = null;
		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new EmployeeNotFoundException("Employee id not found - " + id);
		}
		return RestResponse.ok("200", "Find employee successful!", employee);
		//		return employeeRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public RestResponse<Employee> save(Employee employee) {
		if (employee.getFirstName() == null || employee.getLastName() == null || employee.getEmail() == null) {
			throw new RequiredFieldsNotMeetException("Data is missing for: " + Employee.class.getName());
		}
		Employee savedEmployee = employeeRepo.save(employee);
		return RestResponse.ok("200", "Create successful!", savedEmployee);
	}
	
	@Override
	@Transactional
	public RestResponse<Employee> update(Employee employee) {
		Employee savedEmployee = employeeRepo.save(employee);
		return RestResponse.ok("200", "Update successful!", savedEmployee);
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		findById(id);
		employeeRepo.deleteById(id);
	}
}
