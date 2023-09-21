package com.example.exam.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	private Long id;
	private String role;
	
	public Role() {
	}
	
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, mappedBy = "role")
	private List<UserRole> userRoles = new ArrayList<>();
	
	public Role(Long id, String role) {
		this.id = id;
		this.role = role;
	}

	
	public Role(Long id, String role, List<UserRole> userRoles) {
		super();
		this.id = id;
		this.role = role;
		this.userRoles = userRoles;
	}

	

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
