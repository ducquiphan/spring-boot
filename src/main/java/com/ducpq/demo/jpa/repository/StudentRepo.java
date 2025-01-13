/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.jpa.repository;

import com.ducpq.demo.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	@Query("from Student s left join fetch s.courses where s.id = :id")
	Optional<Student> findStudentAndCoursesById(int id);
	
}
