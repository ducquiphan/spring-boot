package com.ducpq.demo.thymeleaf.service.impl;

import com.ducpq.demo.thymeleaf.entity.Role;
import com.ducpq.demo.thymeleaf.entity.User;
import com.ducpq.demo.thymeleaf.entity.UserRole;
import com.ducpq.demo.thymeleaf.repository.RoleRepo;
import com.ducpq.demo.thymeleaf.repository.UserRepo;
import com.ducpq.demo.thymeleaf.repository.UserRoleRepo;
import com.ducpq.demo.thymeleaf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final UserRoleRepo userRoleRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				mapRolesToAuthorities(userRoleRepo.findUserRoleByUserId(user.getId()).stream().map(UserRole::getRole).toList()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
	
	
}
