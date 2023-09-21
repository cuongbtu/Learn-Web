package com.example.course.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
	
	
	@OneToMany(cascade = CascadeType.ALL, 
			mappedBy = "role",
			fetch = FetchType.EAGER)
	@JsonIgnore
	private List<RolePermission> rolePermissions = new ArrayList<>();
	
	
	public List<RolePermission> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(List<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}


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
