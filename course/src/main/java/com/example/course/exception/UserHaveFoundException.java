package com.example.course.exception;

public class UserHaveFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserHaveFoundException() {
		super("User không hợp lệ hoặc đã tồn tại !!!");
	}
}
