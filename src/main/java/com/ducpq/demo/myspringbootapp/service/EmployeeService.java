package com.ducpq.demo.myspringbootapp.service;

import com.ducpq.demo.myspringbootapp.entity.Employee;
import com.ducpq.demo.myspringbootapp.playload.response.ListResponse;
import com.ducpq.demo.myspringbootapp.playload.response.RestResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
	RestResponse<ListResponse<List<Employee>>> findAll(Pageable pageable);
	
	RestResponse<Employee> findById(int id);
	
	RestResponse<Employee> save(Employee employee);
	
	RestResponse<Employee> update(Employee employee);
	
	void deleteById(int id);
}
