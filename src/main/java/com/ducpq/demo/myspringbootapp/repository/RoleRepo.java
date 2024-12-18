package com.ducpq.demo.myspringbootapp.repository;

import com.ducpq.demo.myspringbootapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
