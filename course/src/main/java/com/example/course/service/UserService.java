package com.example.course.service;

import java.util.List;

import com.example.course.model.*;

public interface UserService {

	public User createdUser(User user, List<UserRole> userRoles ) throws Exception;

	public User getUser(String userName);
	
	public void deleteUser(Long userId);

	public User updateUser(User user) throws Exception;
}
