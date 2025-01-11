package com.ducpq.demo.jpa;

import com.ducpq.demo.jpa.entity.Course;
import com.ducpq.demo.jpa.entity.Instructor;
import com.ducpq.demo.jpa.entity.InstructorDetail;
import com.ducpq.demo.jpa.repository.InstructorRepo;
import com.ducpq.demo.jpa.service.InstructorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JPAApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(JPAApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(InstructorService instructorService) {
		return runner -> {
			//createInstructor(instructorService);
			//findInstructor(instructorService);
			//deleteInstructor(instructorService);
			//findInstructorDetails(instructorService);
			//deleteInstructorDetails(instructorService);
			//createInstructorWithCourses(instructorService);
			findInstructorWithCourses(instructorService);
		};
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
				.title("Literature")
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
