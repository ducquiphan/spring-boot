package com.ducpq.demo.thymeleaf.repository;

import com.ducpq.demo.thymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("from User where username=:username and isActive=1")
	User findByUsername(String username);
}
