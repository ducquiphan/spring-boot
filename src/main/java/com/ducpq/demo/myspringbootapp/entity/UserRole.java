package com.ducpq.demo.myspringbootapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "user_roles",
		uniqueConstraints = {
				@UniqueConstraint(name = "authorities5_idx_1", columnNames = { "user_id", "role_id" })
		})
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)

public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;
	
}