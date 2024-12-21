package com.ducpq.demo.myspringbootapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String firstName;
	private String lastName;
	private Gender gender;
	private String email;
	private Country country;
	private List<Integer> hobbyIds;
	private String password;
	private String confirmPassword;
}
