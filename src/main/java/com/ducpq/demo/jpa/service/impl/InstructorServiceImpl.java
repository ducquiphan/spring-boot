/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.jpa.service.impl;

import com.ducpq.demo.jpa.entity.Course;
import com.ducpq.demo.jpa.entity.Instructor;
import com.ducpq.demo.jpa.entity.InstructorDetail;
import com.ducpq.demo.jpa.repository.CourseRepo;
import com.ducpq.demo.jpa.repository.InstructorDetailRepo;
import com.ducpq.demo.jpa.repository.InstructorRepo;
import com.ducpq.demo.jpa.service.InstructorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
	
	private final InstructorRepo instructorRepo;
	private final InstructorDetailRepo instructorDetailRepo;
	private final CourseRepo courseRepo;
	
	/**
	 * @param instructor an object which contains all the information of an Instructor
	 * @return the created Instructor
	 */
	@Override
	@Transactional
	public Instructor createInstructor(Instructor instructor) {
		return instructorRepo.save(instructor);
	}
	
	@Override
	public Instructor findInstructorById(int id) {
		//return instructorRepo.findById(id).orElse(null);
		return instructorRepo.findInstructorById(id).orElse(null);
	}
	
	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		return instructorDetailRepo.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Instructor updateInstructor(Instructor instructor) {
		return instructorRepo.save(instructor);
	}
	
	@Override
	public Course updateCourse(Course course) {
		return courseRepo.save(course);
	}
	
	@Override
	public Course findCourseById(int id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		Instructor instructor = instructorRepo.findById(id).orElse(null);
		if (instructor != null) {
			// In @Transactional, if you access property with FetchType.LAZY, it will still get it for you because you are still in a Hibernate
			// Session
			List<Course> courses = instructor.getCourses();
			for (Course course : courses) {
				course.setInstructor(null);
			}
			instructorRepo.delete(instructor);
		} else {
			throw new EntityNotFoundException();
		}
	}
	
	@Override
	@Transactional
	public void deleteInstructorDetailById(int id) {
		InstructorDetail instructorDetail = findInstructorDetailById(id);
		if (instructorDetail != null) {
			// remove the associated object reference
			// break bidirectional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			instructorDetailRepo.delete(instructorDetail);
		} else {
			throw new EntityNotFoundException();
		}
	}
	
	/**
	 * @param id the id of the Course
	 */
	@Override
	@Transactional
	public void deleteCourseById(int id) {
		Course course = findCourseById(id);
		if (course != null) {
			courseRepo.delete(course);
		} else {
			throw new EntityNotFoundException();
		}
	}
	
	@Override
	public List<Course> findCourseByInstructorId(int id) {
		return courseRepo.findByInstructorId(id);
	}
	
	@Override
	public InstructorDetail findInstructorDetailByInstructorId(int id) {
		return instructorDetailRepo.findInstructorDetailByInstructorId(id);
	}
}
