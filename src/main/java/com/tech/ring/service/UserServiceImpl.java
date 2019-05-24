package com.tech.ring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.ring.domain.Role;
import com.tech.ring.domain.User;
import com.tech.ring.enums.TechRingApplicationErrors;
import com.tech.ring.enums.RoleName;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.repository.RoleDao;
import com.tech.ring.repository.UserDao;
import com.tech.ring.request.UserSignUpRequest;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public HashMap<String, String> userSignUp(UserSignUpRequest userSignUpRequest) {
		
		User user = userDao.findByuserName(userSignUpRequest.getUserName());
		
		if(user == null) {
			
			Role role = roleDao.findRoleByroleName(RoleName.ROLE_USER.toString());
			List<Role> roleList = new ArrayList<>();
			roleList.add(role);
			
			if(role != null) {
				User newUser = new User();
				
				newUser.setFirstName(userSignUpRequest.getFirstName());
				newUser.setLastName(userSignUpRequest.getLastName());
				newUser.setUserName(userSignUpRequest.getUserName());
				newUser.setEmail(userSignUpRequest.getEmail());
				newUser.setPassword(passwordEncoder.encode(userSignUpRequest.getPassword()));
				newUser.setRoles(roleList);
				
				User result = userDao.save(newUser);
				
				if(result != null) {
					HashMap<String, String> hm = new HashMap<>();
					hm.put("message", "User created");
					return hm;
				}else {
					throw new TechRingException(TechRingApplicationErrors.USER_NOT_CREATED);
				}
				
			}else {
				throw new TechRingException(TechRingApplicationErrors.USER_ROLE_NOT_FOUND);
			}
	
		}else {
			throw new TechRingException(TechRingApplicationErrors.USER_NAME_ALREADY_EXISTS);
		}
	}

}
