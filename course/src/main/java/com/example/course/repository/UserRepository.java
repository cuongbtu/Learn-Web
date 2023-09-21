package com.example.course.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.model.User;



public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUserName(String userName);
	public Optional<User> findById(Long id);
}
