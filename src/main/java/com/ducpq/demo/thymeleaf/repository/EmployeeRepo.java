package com.ducpq.demo.thymeleaf.repository;

import com.ducpq.demo.thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	List<Employee> findAllByOrderByLastNameAsc();
}
