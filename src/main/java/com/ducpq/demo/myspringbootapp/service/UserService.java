package com.ducpq.demo.myspringbootapp.service;


import com.ducpq.demo.myspringbootapp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	@Query("FROM User WHERE username=:username and isActive=1 ")
	User findByUserName(String username);
}
