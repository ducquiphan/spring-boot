package com.ducpq.demo.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@SuperBuilder(toBuilder = true)
@RequiredArgsConstructor
@ToString(exclude = "instructor")
@Table(name = "`course`")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
}
