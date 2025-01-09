package com.ducpq.demo.jpa.service.impl;

import com.ducpq.demo.jpa.entity.Instructor;
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
	
	@Override
	@Transactional
	public Instructor create(Instructor instructor) {
		return instructorRepo.save(instructor);
	}
	
	@Override
	public Instructor findById(int id) {
		return instructorRepo.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		Instructor instructor = findById(id);
		if (instructor != null) {
			instructorRepo.delete(instructor);
		} else {
			throw new EntityNotFoundException();
		}
	}
}
