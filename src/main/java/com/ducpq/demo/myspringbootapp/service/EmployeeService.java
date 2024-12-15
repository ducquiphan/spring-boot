package com.ducpq.demo.myspringbootapp.service;

import com.ducpq.demo.myspringbootapp.entity.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
	List<Employee> findAll(Pageable pageable);
	
	Employee findById(int id);
	
	Employee save(Employee employee);
	
	Employee update(Employee employee);
	
	void deleteById(int id);
}
