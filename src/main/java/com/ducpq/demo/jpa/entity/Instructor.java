package com.ducpq.demo.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "`instructor`")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy = "instructor",
			cascade = {
					CascadeType.DETACH,
					CascadeType.MERGE,
					CascadeType.REFRESH,
					CascadeType.PERSIST },
			fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<Course> courses;
	
	// add convenience methods for bidirectional relationship
	public void add(Course course) {
		if (courses == null) {
			courses = new ArrayList<>();
		}
		courses.add(course);
		course.setInstructor(this);
	}
}
