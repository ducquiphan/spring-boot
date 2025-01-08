package com.ducpq.demo.thymeleaf.service;

import com.ducpq.demo.thymeleaf.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	User findByUsername(String username);
}
