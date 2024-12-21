package com.ducpq.demo.myspringbootapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
}
