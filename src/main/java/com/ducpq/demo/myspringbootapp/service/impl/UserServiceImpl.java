package com.ducpq.demo.myspringbootapp.service.impl;

import com.ducpq.demo.myspringbootapp.entity.Role;
import com.ducpq.demo.myspringbootapp.entity.User;
import com.ducpq.demo.myspringbootapp.entity.UserRole;
import com.ducpq.demo.myspringbootapp.repository.RoleRepo;
import com.ducpq.demo.myspringbootapp.repository.UserRepo;
import com.ducpq.demo.myspringbootapp.repository.UserRoleRepo;
import com.ducpq.demo.myspringbootapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final UserRoleRepo userRoleRepo;
	
	@Override
	public User findByUserName(String username) {
		return userRepo.findByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		List<Role> userRoles = userRoleRepo.findUserRoleByUserId(user.getId())
				.stream().map(UserRole::getRole).toList();
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), mapRolesToAuthorities(userRoles));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
}
