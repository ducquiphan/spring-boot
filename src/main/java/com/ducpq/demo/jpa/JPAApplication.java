package com.ducpq.demo.jpa;

import com.ducpq.demo.jpa.entity.Instructor;
import com.ducpq.demo.jpa.entity.InstructorDetail;
import com.ducpq.demo.jpa.repository.InstructorRepo;
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
	public CommandLineRunner commandLineRunner(InstructorService instructorService) {
		return runner -> {
			//createInstructor(instructorService);
			//findInstructor(instructorService);
			deleteInstructor(instructorService);
		};
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
		Instructor instructor = instructorService.findById(id);
		System.out.println("Found instructor: " + instructor);
		if (instructor != null) {
			System.out.println("The associate instructorDetail only: " + instructor.getInstructorDetail());
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
		instructorService.create(instructor);
	}
}
