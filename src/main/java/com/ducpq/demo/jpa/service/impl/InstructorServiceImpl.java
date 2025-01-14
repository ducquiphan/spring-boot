/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.jpa.service.impl;

import com.ducpq.demo.jpa.entity.Course;
import com.ducpq.demo.jpa.entity.Instructor;
import com.ducpq.demo.jpa.entity.InstructorDetail;
import com.ducpq.demo.jpa.entity.Student;
import com.ducpq.demo.jpa.repository.*;
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
	private final ReviewRepo reviewRepo;
	private final StudentRepo studentRepo;
	
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
	
	/**
	 * @param course an object which contains all the information of a Course
	 * @return the created Course
	 */
	@Override
	@Transactional
	public Course createCourse(Course course) {
		return courseRepo.save(course);
	}
	
	@Override
	@Transactional
	public Course updateCourse(Course course) {
		return courseRepo.save(course);
	}
	
	@Override
	public Course findCourseById(int id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@Override
	public Course findCourseAndReviewsByCourseId(int id) {
		return courseRepo.findCourseAndReviewsById(id).orElse(null);
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
	
	/**
	 * @param id
	 * @return
	 */
	@Override
	public Student findStudentById(int id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@Override
	public Student findStudentAndCoursesById(int id) {
		return studentRepo.findStudentAndCoursesById(id).orElse(null);
	}
	
	/**
	 * @param student
	 */
	@Override
	@Transactional
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@Override
	public Course findCourseAndStudentsById(int id) {
		return courseRepo.findCourseAndStudentsById(id).orElse(null);
	}
	
	/**
	 * @param student
	 * @return
	 */
	@Override
	@Transactional
	public void addStudentToCourse(Student student, Course course) {
		Student studentDB = studentRepo.findStudentAndCoursesById(student.getId()).orElse(student);
		Course courseDB = courseRepo.findCourseAndStudentsById(course.getId()).orElse(course);
		if (studentDB != null && courseDB != null) {
			System.out.println("Got student: " + studentDB);
			System.out.println("Got student's courses: " + studentDB.getCourses());
			System.out.println("Got course: " + courseDB);
			System.out.println("Got course's students: " + courseDB.getStudents());
			courseDB.addStudent(studentDB);
			studentDB.addCourse(courseDB);
			System.out.println("Current student's courses: " + studentDB.getCourses());
			studentRepo.save(studentDB);
			courseDB = courseRepo.findCourseAndStudentsById(course.getId()).orElse(courseDB);
			System.out.println("Course: " + courseDB);
			System.out.println("Student of course: " + courseDB.getStudents());
		}
		
	}
}
