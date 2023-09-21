package com.example.exam.entity.authentication;

public class AuthendicationResponce {

	String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthendicationResponce(String token) {
		super();
		this.token = token;
	}

	public AuthendicationResponce() {
		super();
	}
	
	
}
