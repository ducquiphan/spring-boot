package com.ducpq.demo.thymeleaf.service;

import com.ducpq.demo.thymeleaf.entity.Employee;
import com.ducpq.demo.thymeleaf.playload.response.ListResponse;
import com.ducpq.demo.thymeleaf.playload.response.RestResponse;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
	RestResponse<ListResponse<Employee>> findAll(Pageable pageable);
	
	RestResponse<Employee> findById(int id);
	
	RestResponse<Employee> save(Employee employee);
	
	RestResponse<Employee> update(Employee employee);
	
	void deleteById(int id);
}
