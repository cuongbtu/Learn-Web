package com.example.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exam.entity.Role;
import com.example.exam.entity.User;
import com.example.exam.entity.UserRole;
import com.example.exam.exception.UserNotFoundException;
import com.example.exam.repository.UserRepository;
import com.example.exam.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	UserRepository userRepository;

	@PostMapping
	public User CreatedUser(@RequestBody User user) throws Exception {

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
	public User updateUser(@RequestBody User user) {
		User local = userRepository.findByUserName(user.getUserName());
		if (local == null) {
			throw new UserNotFoundException();
		} else {
			if (user.getFirstName() != null && !user.getFirstName().isEmpty()) {
				local.setFirstName(user.getFirstName());
			}
			if (user.getLastName() != null && !user.getLastName().isEmpty()) {
				local.setLastName(user.getLastName());
			}
			if (user.getPassword() != null && !user.getPassword().isEmpty()) {
				local.setPassword(user.getPassword());
			}
			if (user.getEmail() != null && !user.getEmail().isEmpty()) {
				local.setEmail(user.getEmail());
			}
			if (user.getProfile() != null && !user.getProfile().isEmpty()) {
				local.setProfile(user.getProfile());
			}
			local = this.userRepository.save(local);
		}
		return local;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> exceptionhandler(UserNotFoundException exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User không tồn tại !!");
	}
}
