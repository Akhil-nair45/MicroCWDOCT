package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.User;

public interface UserService {

	
	public User saveUser(User user);
	
	public User findUserById(String userId);
	
	public List<User> findAll();
	
	public String deleteUser(String userId);
	
	public User editUser(User user);
	
}
