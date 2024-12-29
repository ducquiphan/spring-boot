package com.ducpq.demo.thymeleaf.repository;

import com.ducpq.demo.thymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
