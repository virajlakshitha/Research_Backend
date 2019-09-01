package com.tech.ring.service;

import java.util.HashMap;

import com.tech.ring.domain.User;
import com.tech.ring.request.UserSignUpRequest;


public interface UserService {
	
	public HashMap<String, String> userSignUp(UserSignUpRequest userSignUpRequest);
	
	public User getUsers(String id);
}
