package com.example.course.model;

import java.util.ArrayList;
import java.util.List;

import com.example.course.model.Course.Order;
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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private boolean enabled = true;
	

	@OneToMany(cascade = CascadeType.ALL, 
			mappedBy = "user",
			fetch = FetchType.EAGER)
	@JsonIgnore
	private List<UserRole> userRoles = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, 
			mappedBy = "user",
			fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Session> sessions = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, 
			mappedBy = "user",
			fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();
	
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public User() {
	}
	
	public User(Long id, String userName, String password, String firstName, String lastName, String email,
			boolean enabled) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


}

