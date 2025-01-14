/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.jpa;

import com.ducpq.demo.jpa.entity.*;
import com.ducpq.demo.jpa.repository.StudentRepo;
import com.ducpq.demo.jpa.service.InstructorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class JPAApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(JPAApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(InstructorService instructorService, StudentRepo studentRepo) {
		return runner -> {
			//createInstructor(instructorService);
			//findInstructor(instructorService);
			//deleteInstructor(instructorService);
			//findInstructorDetails(instructorService);
			//deleteInstructorDetails(instructorService);
			//createInstructorWithCourses(instructorService);
			//findInstructorWithCourses(instructorService);
			//updateInstructor(instructorService);
			//updateCourse(instructorService);
			//deleteCourse(instructorService);
			//createCourseAndReviews(instructorService);
			//findCourseAndReviews(instructorService);
			//deleteCourseAndReviews(instructorService);
			//createCourseAndStudent(instructorService);
			addStudentCourse(instructorService, studentRepo);
		};
	}
	
	private void createCourseAndStudent(InstructorService instructorService) {
		Course course1 = Course.builder()
				.title("This is the course for student in Class 3!").build();
		Course course2 = Course.builder()
				.title("This is the course for student in Class 4!").build();
		
		Student student1 = Student.builder()
				.firstName("Duckkk")
				.lastName("Phannn")
				.email("phanquiduc@gmail.com").build();
		Student student2 = Student.builder()
				.firstName("Skyyyyyy")
				.lastName("Thiennn")
				.email("thiensky@gmail.com").build();
		
		course1.addStudent(student1);
		course1.addStudent(student2);
		
		Course createdCourse1 = instructorService.createCourse(course1);
		
		System.out.println("Created course 3: " + course1);
		System.out.println("Student of course 3: " + createdCourse1.getStudents());
		
		Course createdCourse2 = instructorService.createCourse(course2);
		
		for (Student student : createdCourse1.getStudents()) {
			student.addCourse(createdCourse2);
			instructorService.updateStudent(student);
		}
		
		createdCourse2 = instructorService.findCourseAndStudentsById(createdCourse2.getId());
		
		System.out.println("Created course 4: " + createdCourse2);
		System.out.println("Student of course 4: " + createdCourse2.getStudents());
		
	}
	
	public void addStudentCourse(InstructorService instructorService, StudentRepo studentRepo) {
		//		Student student1 = instructorService.findStudentAndCoursesById(5);
		//		Student student2 = instructorService.findStudentAndCoursesById(6);
		//
		//		System.out.println("Got student 1: " + student1);
		//		System.out.println("Got student 1's courses: " + student1.getCourses());
		//
		//		System.out.println("Got student 2: " + student2);
		//		System.out.println("Got student 2's courses: " + student2.getCourses());
		//
		//		Course course = instructorService.findCourseById(15);
		//
		//		System.out.println("Got course: " + course);
		//
		//		student1.addCourse(course);
		//		student2.addCourse(course);
		//		//course.addStudent(student1);
		//		//course.addStudent(student2);
		//
		//		System.out.println("Current student 1's courses: " + student1.getCourses());
		//		System.out.println("Current student 2's courses: " + student2.getCourses());
		//
		//
		//		studentRepo.save(student1);
		//		studentRepo.save(student2);
		//		//instructorService.updateStudent(student1);
		//		//instructorService.updateStudent(student2);
		//		//instructorService.updateCourse(course);
		//
		//		course = instructorService.findCourseAndStudentsById(course.getId());
		//
		//		System.out.println("Course 4: " + course);
		//		System.out.println("Student of course 4: " + course.getStudents());
		
		Student student = instructorService.findStudentById(6);
		Course course = instructorService.findCourseById(15);
		
		instructorService.addStudentToCourse(student, course);
	}
	
	private void deleteCourseAndReviews(InstructorService instructorService) {
		int id = 1;
		System.out.println("Deleting course id: " + id);
		// this will also delete all Reviews because of CascadeType.ALL
		instructorService.deleteCourseById(id);
	}
	
	private void findCourseAndReviews(InstructorService instructorService) {
		int theId = 1;
		System.out.println("Finding course and reviews with id: " + theId);
		Course course = instructorService.findCourseAndReviewsByCourseId(theId);
		
		System.out.println("Course info: " + course);
		System.out.println("Course's reviews: " + course.getReviews());
		
	}
	
	private void createCourseAndReviews(InstructorService instructorService) {
		Review review1 = Review.builder()
				.comment("This course is amazing!").build();
		Review review2 = Review.builder()
				.comment("This course is suitable for beginner!").build();
		
		Course course = Course.builder()
				.title("Math")
				.build();
		
		course.addReview(review1);
		course.addReview(review2);
		course.addReview(new Review("This is not a course I want"));
		
		System.out.println("Saving the course");
		
		Course createdCourse = instructorService.createCourse(course);
		System.out.println("The created course: " + createdCourse);
		System.out.println("Its reviews: " + course.getReviews());
	}
	
	private void deleteCourse(InstructorService instructorService) {
		int id = 10;
		System.out.println("Deleting course with id: " + id);
		instructorService.deleteCourseById(id);
		System.out.println("Done!!");
	}
	
	
	private void updateCourse(InstructorService instructorService) {
		int theId = 10;
		System.out.println("Finding course with id: " + theId);
		Course course = instructorService.findCourseById(theId);
		
		course.setTitle("This is Math for Intermediate");
		
		Course updatedCourse = instructorService.updateCourse(course);
		
		System.out.println("Updated course information: " + updatedCourse);
		System.out.println("Done");
	}
	
	private void updateInstructor(InstructorService instructorService) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		Instructor instructor = instructorService.findInstructorById(theId);
		
		instructor.setFirstName("Empty Name");
		
		//		Course course1 = Course.builder()
		//				.title("This is the course for Level 1!")
		//				.build();
		//		Course course2 = Course.builder()
		//				.title("This is the course for Level 2!")
		//				.build();
		
		//		instructor.add(course1);
		//		instructor.add(course2);
		
		Instructor updatedInstructor = instructorService.updateInstructor(instructor);
		
		System.out.println("Updated instructor information: " + updatedInstructor);
		System.out.println("Done");
	}
	
	private void findInstructorWithCourses(InstructorService instructorService) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		Instructor instructor = instructorService.findInstructorById(theId);
		
		//InstructorDetail instructorDetail = instructorService.findInstructorDetailByInstructorId(theId);
		//instructor.setInstructorDetail(instructorDetail);
		
		System.out.println("Found instructor: " + instructor);
		
		//List<Course> courses = instructorService.findCourseByInstructorId(instructor.getId());
		//instructor.setCourses(courses);
		
		//System.out.println("The associated courses: " + instructor.getCourses());
		System.out.println("Done");
	}
	
	private void createInstructorWithCourses(InstructorService instructorService) {
		InstructorDetail instructorDetail = InstructorDetail.builder()
				.hobby("sing")
				.youtubeChannel("DucPhanLoveSkyThien")
				.build();
		
		Course course1 = Course.builder()
				.title("Math")
				.build();
		
		Course course2 = Course.builder()
				.title("Science")
				.build();
		
		Instructor instructor = Instructor.builder()
				.firstName("Phan")
				.lastName("Qui Duc")
				.email("phanquiduc@gmail.com")
				.instructorDetail(instructorDetail)
				.build();
		
		instructor.add(course1);
		instructor.add(course2);
		
		System.out.println("Saving the instructor with courses: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
		instructorService.createInstructor(instructor);
		System.out.println("Done");
	}
	
	private void deleteInstructorDetails(InstructorService instructorService) {
		int id = 3;
		System.out.println("Deleting instructor detail with id: " + id);
		instructorService.deleteInstructorDetailById(id);
		System.out.println("Done!!");
	}
	
	private void deleteInstructor(InstructorService instructorService) {
		int id = 1;
		System.out.println("Deleting instructor with id: " + id);
		instructorService.deleteInstructorById(id);
		System.out.println("Done!!");
	}
	
	private void findInstructor(InstructorService instructorService) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = instructorService.findInstructorById(id);
		System.out.println("Found instructor: " + instructor);
		if (instructor != null) {
			System.out.println("The associate instructorDetail only: " + instructor.getInstructorDetail());
		}
	}
	
	private void findInstructorDetails(InstructorService instructorService) {
		int id = 2;
		System.out.println("Finding instructor details id: " + id);
		InstructorDetail instructorDetail = instructorService.findInstructorDetailById(id);
		System.out.println("Found instructor detail: " + instructorDetail);
		if (instructorDetail != null) {
			System.out.println("The associate instructor only: " + instructorDetail.getInstructor());
		}
	}
	
	private void createInstructor(InstructorService instructorService) {
		InstructorDetail instructorDetail = InstructorDetail.builder()
				.hobby("sing")
				.youtubeChannel("DucPhan")
				.build();
		
		Instructor instructor = Instructor.builder()
				.firstName("Phan")
				.lastName("Qui Duc")
				.email("phanquiduc@gmail.com")
				.instructorDetail(instructorDetail)
				.build();
		
		System.out.println("Saving the instructor: " + instructor);
		instructorService.createInstructor(instructor);
	}
}
