package com.ducpq.demo.myspringbootapp.dao;

import com.ducpq.demo.myspringbootapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee employee);
	
	void remove(int id);
}
