package com.ducpq.demo.myspringbootapp.model;

import jakarta.validation.constraints.*;
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
	@NotNull(message = "Please input your first name")
	@Size(min = 1, max = 255, message = "Your first name length must be between 1 and 255")
	private String firstName;
	@NotNull(message = "Please input your last name")
	@Size(min = 1, max = 255, message = "Your last name length must be between 1 and 255")
	private String lastName;
	private Gender gender;
	@NotNull(message = "Age cannot be empty")
	@Min(value = 6, message = "Age must be greater than or equal to 6")
	@Max(value = 150, message = "Age must be less than or equal to 150")
	@Pattern(regexp = "^\\d+", message = "Only numbers are allowed")
	private Integer age;
	private String email;
	private Country country;
	private List<Integer> hobbyIds;
	private String password;
	private String confirmPassword;
}
