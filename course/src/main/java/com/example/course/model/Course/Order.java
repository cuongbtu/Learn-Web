package com.example.course.model.Course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.course.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date orderTime;
	private Float total;
	private Boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@OneToMany(cascade = CascadeType.ALL, 
			mappedBy = "order",
			fetch = FetchType.EAGER)
	@JsonIgnore
	private List<OrderCourse> orderCourses = new ArrayList<>();
	
	public List<OrderCourse> getOrderCourses() {
		return orderCourses;
	}

	public void setOrderCourses(List<OrderCourse> orderCourses) {
		this.orderCourses = orderCourses;
	}

	public Order() {
		super();
	}

	public Order(Long id, Date orderTime, Float total, Boolean status, User user) {
		super();
		this.id = id;
		this.orderTime = orderTime;
		this.total = total;
		this.status = status;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
