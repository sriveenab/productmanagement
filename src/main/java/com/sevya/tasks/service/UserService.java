package com.sevya.tasks.service;

import java.util.List;

import com.sevya.tasks.model.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public User saveUser(User user);
	
	public User getUserByEmail(String email);
	
}
