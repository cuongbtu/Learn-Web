package com.example.course.service.implement;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.exception.UserHaveFoundException;
import com.example.course.exception.UserNotFoundException;
import com.example.course.model.User;
import com.example.course.model.UserRole;
import com.example.course.repository.RoleReponsitory;
import com.example.course.repository.UserRepository;
import com.example.course.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleReponsitory roleReponsitory;
	
	
//	Thêm user kiểm tra đã có chưa và không được để trống username, password, email
	@Override
	public User createdUser(User user, List<UserRole> userRoles) throws UserHaveFoundException{
		
		User local=this.userRepository.findByUserName(user.getUserName());
		if(local!=null || user.getUserName() == null || user.getUserName().isEmpty()
				|| user.getPassword() == null || user.getPassword().isEmpty()
				|| user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new UserHaveFoundException();
		} else {
			for(UserRole ur:userRoles) {
				roleReponsitory.save(ur.getRole());
			}
			if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
	            user.setFirstName("N/A");
	        }
			if (user.getLastName() == null || user.getLastName().isEmpty()) {
	            user.setLastName("N/A");
	        }
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user);
		}
		return local;
	}
	
//	Lấy thông tin user
	@Override
	public User getUser(String userName) throws UserNotFoundException {
		if(this.userRepository.findByUserName(userName)==null) {
			throw new UserNotFoundException();
		} else {
			return this.userRepository.findByUserName(userName);
		}
	}

	
//	Xóa user
	@Override
	public void deleteUser(Long userId) throws UserNotFoundException {
		if(this.userRepository.findById(userId)==null) {
			throw new UserNotFoundException();
		} else {
			this.userRepository.deleteById(userId);
		}
	}

	
//	Cập nhật lại user và không để trống
	@Override
	public User updateUser(User user) throws Exception {
		User local=this.userRepository.findByUserName(user.getUserName());
		if(local==null) {
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
			local = this.userRepository.save(local);
		}
		return local;
	}
	
	
}
