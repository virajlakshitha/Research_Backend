package com.tech.ring.repository;

import com.tech.ring.domain.User;

public interface UserDao{
	
	public User findUser(String username, String password);
	
	public User findUserById(String id);
	
	public User saveUser(User user);
	
	public User findByuserName(String username);
}
