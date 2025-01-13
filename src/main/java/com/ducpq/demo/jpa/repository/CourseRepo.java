/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.jpa.repository;

import com.ducpq.demo.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
	
	@Query("from Course where instructor.id = :id")
	List<Course> findByInstructorId(int id);
	
	@Query("from Course c left join fetch c.reviews where c.id = :id")
	Optional<Course> findCourseAndReviewsById(int id);
	
	@Query("from Course c left join fetch c.students where c.id = :id")
	Optional<Course> findCourseAndStudentsById(int id);
}
