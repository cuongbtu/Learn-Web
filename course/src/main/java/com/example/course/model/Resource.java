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
@Table(name ="resources")
public class Resource {

	@Id
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, mappedBy = "resource")
	private List<PermissionResource> permissionResources = new ArrayList<>();
	
	
	
	public List<PermissionResource> getPermissionResources() {
		return permissionResources;
	}

	public void setPermissionResources(List<PermissionResource> permissionResources) {
		this.permissionResources = permissionResources;
	}

	public Resource() {
		super();
	}

	public Resource(Long id, String name) {
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
