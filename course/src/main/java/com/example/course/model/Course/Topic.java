package com.example.course.model.Course;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic {

	@Id
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, mappedBy = "topic")
	private List<CourseTopic> courseTopics = new ArrayList<>();
	
	public Topic() {
		super();
	}

	public List<CourseTopic> getCourseTopics() {
		return courseTopics;
	}

	public void setCourseTopics(List<CourseTopic> courseTopics) {
		this.courseTopics = courseTopics;
	}

	public Topic(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
