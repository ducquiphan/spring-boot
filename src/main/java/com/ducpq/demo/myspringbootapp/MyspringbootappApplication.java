package com.ducpq.demo.myspringbootapp;

import com.ducpq.demo.myspringbootapp.dao.StudentDAO;
import com.ducpq.demo.myspringbootapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

//@SpringBootApplication(
//		scanBasePackages = { "com.ducpq.demo.myspringbootapp",
//				"com.ducpq.demo.utils" })
@SpringBootApplication
public class MyspringbootappApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyspringbootappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//getStudent(studentDAO);
			//getAllStudent(studentDAO);
			//getStudentBySearchTerm(studentDAO, "white");
			//updateStudent(studentDAO, 1);
			//deleteStudent(studentDAO, 5);
		};
	}
	
	private void deleteStudent(StudentDAO studentDAO, int i) {
		studentDAO.delete(i);
		System.out.println("Delete student successfully!");
	}
	
	private void updateStudent(StudentDAO studentDAO, Integer studentId) {
		// get student based on id
		Student foundStudent = studentDAO.findById(studentId);
		
		// update email
		foundStudent.setEmail("phanquiduc123@gmail.com");
		Student updatedStudent = studentDAO.update(foundStudent);
		
		// output updated student information
		System.out.println("Updated student information: " + updatedStudent);
	}
	
	private void getStudentBySearchTerm(StudentDAO studentDAO, String searchTerm) {
		// get list of students in db
		System.out.println("Getting list of student...");
		List<Student> students = studentDAO.findBySearchTerm(searchTerm);
		
		// display list of students
		System.out.println("Displaying list of students...");
		for (Student student : students) {
			System.out.println("Student information: " + student);
		}
	}
	
	private void getAllStudent(StudentDAO studentDAO) {
		// get list of students in db
		System.out.println("Getting list of student...");
		List<Student> students = studentDAO.findAll();
		
		// display list of students
		System.out.println("Displaying list of students...");
		for (Student student : students) {
			System.out.println("Student information: " + student);
		}
	}
	
	private void getStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Duc", "Phan", "phanquiduc102@gmail.com");
		
		// save student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		
		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		
		// retrieve student based on the id
		System.out.println("Retrieving student with id: " + tempStudent.getId());
		
		Student createdStudent = studentDAO.findById(tempStudent.getId());
		
		System.out.println("Found student: " + createdStudent);
	}
	
	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating 3 students object...");
		Student tempStudent1 = new Student("Duc", "White", "phanquiduc102@gmail.com");
		Student tempStudent2 = new Student("Duc", "Swift", "phanquiduc103@gmail.com");
		Student tempStudent3 = new Student("Duc", "Thien", "phanquiduc104@gmail.com");
		
		// save student object
		System.out.println("Saving those students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	
	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Duc", "Phan", "phanquiduc102@gmail.com");
		
		// save student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		
		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
