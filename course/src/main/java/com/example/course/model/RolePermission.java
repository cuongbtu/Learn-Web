package com.example.course.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RolePermission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY)
	private Permission permission;

	
	
	public RolePermission() {
		super();
	}

	
	
	public RolePermission(Long id, Role role, Permission permission) {
		super();
		this.id = id;
		this.role = role;
		this.permission = permission;
	}



	public Long getId() {
		return id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
