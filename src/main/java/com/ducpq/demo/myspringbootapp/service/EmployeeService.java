package com.ducpq.demo.myspringbootapp.service;

import com.ducpq.demo.myspringbootapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee employee);
	
	Employee update(Employee employee);
	
	void deleteById(int id);
}
