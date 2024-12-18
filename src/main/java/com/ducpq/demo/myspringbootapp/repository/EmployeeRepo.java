package com.ducpq.demo.myspringbootapp.repository;

import com.ducpq.demo.myspringbootapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
