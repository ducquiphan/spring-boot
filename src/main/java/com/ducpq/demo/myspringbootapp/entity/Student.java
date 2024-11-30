package com.ducpq.demo.myspringbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private boolean isActive;
	
}
