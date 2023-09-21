package com.example.exam.service;

import java.util.List;

import com.example.exam.entity.User;
import com.example.exam.entity.UserRole;

public interface UserService {

	public User createdUser(User user, List<UserRole> userRoles ) throws Exception;

	public User getUser(String userName);
	
	public void deleteUser(Long userId);
	
	public User updateUser(User user, List<UserRole> userRoles) throws Exception;
}
