package com.example.exam.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exam.entity.User;
import com.example.exam.entity.UserRole;
import com.example.exam.repository.RoleReponsitory;
import com.example.exam.repository.UserRepository;
import com.example.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleReponsitory roleReponsitory;
	
	@Override
	public User createdUser(User user, List<UserRole> userRoles) throws Exception{
		
		User local=this.userRepository.findByUserName(user.getUserName());
		if(local!=null) {
			System.out.println("User đã tồn tại!");
			throw new Exception("User đã tồn tại!");
		} else {
			for(UserRole ur:userRoles) {
				roleReponsitory.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String userName) {
		return this.userRepository.findByUserName(userName);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}

	@Override
	public User updateUser(User user, List<UserRole> userRoles) throws Exception {
		User local=this.userRepository.findByUserName(user.getUserName());
		if(local==null) {
			throw new Exception("User không tồn tại!");
		} else {
			local.setFirstName(user.getFirstName());
			local.setLastName(user.getLastName());
			local.setPassword(user.getPassword());
			local.setEmail(user.getEmail());
			local.setProfile(user.getProfile());
			local=this.userRepository.save(user);
		}
		return local;
	}
}
