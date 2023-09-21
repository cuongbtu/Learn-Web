package com.example.exam.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super("User không tồn tại !!!");
	}
}
