package com.ducpq.demo.myspringbootapp.dao.impl;

import com.ducpq.demo.myspringbootapp.dao.EmployeeDAO;
import com.ducpq.demo.myspringbootapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	// define field for entityManager
	private final EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// create a query
		TypedQuery<Employee> query =
				entityManager.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// return the results
		return employees;
	}
	
	@Override
	public Employee findById(int id) {
		// return the results
		return entityManager.find(Employee.class, id);
	}
	
	@Override
	public Employee save(Employee employee) {
		return entityManager.merge(employee);
	}
	
	@Override
	public void remove(int id) {
		entityManager.remove(findById(id));
	}
}
