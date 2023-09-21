package com.example.course.model.Course;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String des;
	private Float price;
	
	@OneToMany(cascade = CascadeType.ALL, 
			mappedBy = "course",
			fetch = FetchType.EAGER)
	@JsonIgnore
	private List<CourseTopic> courseTopics = new ArrayList<>();
	
	
	@OneToMany(cascade = CascadeType.ALL, 
			mappedBy = "course",
			fetch = FetchType.EAGER)
	@JsonIgnore
	private List<OrderCourse> orderCourses = new ArrayList<>();
	
	public List<OrderCourse> getOrderCourses() {
		return orderCourses;
	}
	public void setOrderCourses(List<OrderCourse> orderCourses) {
		this.orderCourses = orderCourses;
	}
	public List<CourseTopic> getCourseTopics() {
		return courseTopics;
	}
	public void setCourseTopics(List<CourseTopic> courseTopics) {
		this.courseTopics = courseTopics;
	}
	public Course() {
		super();
	}
	public Course(Long id, String name, String des, Float price) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
		this.price = price;
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
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
}

