package com.example.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.exception.UserHaveFoundException;
import com.example.course.exception.UserNotFoundException;
import com.example.course.model.Role;
import com.example.course.model.User;
import com.example.course.model.UserRole;
import com.example.course.repository.UserRepository;
import com.example.course.service.UserService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	UserRepository userRepository;

	@PostMapping
	public User CreatedUser(@RequestBody User user, Model model) throws Exception {

		Role role = new Role();
		role.setId(2L);
		role.setRole("USER");

		List<UserRole> userRoles = new ArrayList<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);

		return this.userService.createdUser(user, userRoles);
	}

	@GetMapping("/{username}")
	public User GetUser(@PathVariable("username") String username) throws Exception {
		return this.userService.getUser(username);
	}

	@DeleteMapping("/{userId}")
	public void DeleteUser(@PathVariable("userId") Long userId) throws Exception {
		this.userService.deleteUser(userId);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user) throws Exception {
		return this.userService.updateUser(user);
	}
	
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> exceptionhandler(UserNotFoundException exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User không tồn tại !!");
	}
	
	@ExceptionHandler(UserHaveFoundException.class)
	public ResponseEntity<?> exceptionhandler(UserHaveFoundException exception){
		return ResponseEntity.status(HttpStatus.CONFLICT).body("User không hợp lệ hoặc đã tồn tại !!");
	}
}
