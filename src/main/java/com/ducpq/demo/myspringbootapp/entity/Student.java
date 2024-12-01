package com.ducpq.demo.myspringbootapp.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Student {
	
	@Generated()
	private int id;
	private String firstName;
	private String lastName;
	//	private boolean isActive;
	
}
