package com.ducpq.demo.myspringbootapp.service.impl;

import com.ducpq.demo.myspringbootapp.dao.EmployeeDAO;
import com.ducpq.demo.myspringbootapp.entity.Employee;
import com.ducpq.demo.myspringbootapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
	
	@Override
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}
	
	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeDAO.save(employee);
	}
	
	@Override
	@Transactional
	public Employee update(Employee employee) {
		return employeeDAO.save(employee);
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDAO.remove(id);
	}
}
