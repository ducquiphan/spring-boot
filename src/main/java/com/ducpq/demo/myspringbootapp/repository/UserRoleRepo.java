package com.ducpq.demo.myspringbootapp.repository;

import com.ducpq.demo.myspringbootapp.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleRepo extends JpaRepository<UserRole, Integer> {
	@Query("SELECT ur FROM UserRole ur JOIN FETCH ur.user WHERE ur.user.id = :userId")
	List<UserRole> findUserRoleByUserId(@Param("userId") Integer userId);
}
