package com.ducpq.demo.jpa.service.impl;

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

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
	
	private final InstructorRepo instructorRepo;
	private final InstructorDetailRepo instructorDetailRepo;
	private final CourseRepo courseRepo;
	
	@Override
	@Transactional
	public Instructor createInstructor(Instructor instructor) {
		return instructorRepo.save(instructor);
	}
	
	@Override
	public Instructor findInstructorById(int id) {
		return instructorRepo.findById(id).orElse(null);
	}
	
	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		return instructorDetailRepo.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		Instructor instructor = findInstructorById(id);
		if (instructor != null) {
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
}
