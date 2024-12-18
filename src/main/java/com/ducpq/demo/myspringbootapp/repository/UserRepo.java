package com.ducpq.demo.myspringbootapp.repository;

import com.ducpq.demo.myspringbootapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
