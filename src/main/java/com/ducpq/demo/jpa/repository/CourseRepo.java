package com.ducpq.demo.jpa.repository;

import com.ducpq.demo.jpa.entity.Course;
import com.ducpq.demo.jpa.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
