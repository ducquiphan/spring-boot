package com.ducpq.demo.myspringbootapp.service.impl;

import com.ducpq.demo.myspringbootapp.entity.Employee;
import com.ducpq.demo.myspringbootapp.exception.EmployeeNotFoundException;
import com.ducpq.demo.myspringbootapp.repository.EmployeeRepository;
import com.ducpq.demo.myspringbootapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;
		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new EmployeeNotFoundException("Employee id not found - " + id);
		}
		return employee;
		//		return employeeRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	@Transactional
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
