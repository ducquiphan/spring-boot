package com.ducpq.demo.jpa.repository;

import com.ducpq.demo.jpa.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepo extends JpaRepository<InstructorDetail, Integer> {
	
	InstructorDetail findInstructorDetailByInstructorId(int id);
	
}
