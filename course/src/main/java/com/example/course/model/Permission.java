package com.example.course.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permission {

	@Id
	private Long id;
	private String name;
	
	public Permission() {
		super();
	}

	public List<RolePermission> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(List<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, mappedBy = "permission")
	private List<RolePermission> rolePermissions = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, mappedBy = "permission")
	private List<PermissionResource> permissionResources = new ArrayList<>();
	
	
	
	public List<PermissionResource> getPermissionResources() {
		return permissionResources;
	}

	public void setPermissionResources(List<PermissionResource> permissionResources) {
		this.permissionResources = permissionResources;
	}

	public Permission(Long id, String name) {
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
