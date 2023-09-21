package com.example.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exam.entity.Role;
import com.example.exam.entity.User;

public interface RoleReponsitory extends JpaRepository<Role, Long>{

}
