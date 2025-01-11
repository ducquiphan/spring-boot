/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Review
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-11
 */
@Entity
@ToString
@Setter
@Getter
@RequiredArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "`review`")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "comment")
	private String comment;
	
	public Review(String comment) {
		this.comment = comment;
	}
}
