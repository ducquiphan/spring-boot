/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.jpa.repository;

import com.ducpq.demo.jpa.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Integer> {
	
	@Query("select i from Instructor i join fetch i.instructorDetail join fetch i.courses where i.id = :id")
	Optional<Instructor> findInstructorById(int id);
}
