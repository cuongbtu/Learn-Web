package com.example.exam.entity.authentication;

public class AuthendicationRequest {

	String username;
	String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthendicationRequest() {
		super();
	}
	public AuthendicationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
