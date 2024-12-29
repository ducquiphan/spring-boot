package com.ducpq.demo.thymeleaf.repository;

import com.ducpq.demo.thymeleaf.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
