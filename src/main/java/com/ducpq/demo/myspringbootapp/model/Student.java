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
	private Integer age;
	@Email
	private String email;
	@NotNull(message = "Phone cannot be empty")
	@Pattern(regexp = "^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4\\d|5[1|2|4-9]|6[0-3|9]|7[0-7]|8\\d|9[0-4|6|7|9])" +
			"|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])(\\d{7})$", message = "Phone number is in incorrect format!")
	private String phone;
	private Country country;
	private List<Integer> hobbyIds;
	private String password;
	private String confirmPassword;
}
