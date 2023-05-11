package com.examportal.service;

import java.util.Set;

import com.examportal.model.User;
import com.examportal.model.UserRole;

public interface UserService {
   //Creating User
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	// Get User
	public User getUser(String username);
	//delete user
	public void deleteUser(Long id);
}
