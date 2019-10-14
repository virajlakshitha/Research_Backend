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
//	@Transactional
	public HashMap<String, String> userSignUp(UserSignUpRequest userSignUpRequest, String role) {
		
		User user = userDao.findByuserName(userSignUpRequest.getUsername());
		if(user == null) {
			if(role.equals("customer")) {
//			Role role = roleDao.findRoleByroleName(RoleName.ROLE_USER.toString());
//			List<Role> roleList = new ArrayList<>();
//			roleList.add(role);
//			
//			if(role != null) {
				User newUser = new User();
//				
//				newUser.setFirstName(userSignUpRequest.getFirstName());
//				newUser.setLastName(userSignUpRequest.getLastName());
				newUser.setUserName(userSignUpRequest.getUsername());
				newUser.setEmail(userSignUpRequest.getEmail());
				newUser.setPassword(passwordEncoder.encode(userSignUpRequest.getPassword()));
				newUser.setType("customer");
//				newUser.setRoles(roleList);
//				
				User result = userDao.saveUser(newUser);
//				
				if(result != null) {
					HashMap<String, String> hm = new HashMap<>();
					hm.put("message", "User created");
					return hm;
				}else {
					throw new TechRingException(TechRingApplicationErrors.USER_NOT_CREATED);
				}
				
//			}else {
//				throw new TechRingException(TechRingApplicationErrors.USER_ROLE_NOT_FOUND);
//			}
			} else if(role.equals("vendor")) {
				User newUser = new User();
				newUser.setUserName(userSignUpRequest.getUsername());
				newUser.setEmail(userSignUpRequest.getEmail());
				newUser.setPassword(passwordEncoder.encode(userSignUpRequest.getPassword()));
				newUser.setCity(userSignUpRequest.getCity());
				newUser.setProvince(userSignUpRequest.getProvince());
				newUser.setStreet1(userSignUpRequest.getStreet1());
				newUser.setStreet2(userSignUpRequest.getStreet2());
				newUser.setTel(userSignUpRequest.getTel());
				newUser.setMobile(userSignUpRequest.getMobile());
				newUser.setCard_no(userSignUpRequest.getCard_no());
				newUser.setType("vendor");
				User result = userDao.saveUser(newUser);
				
				if(result != null) {
					HashMap<String, String> hm = new HashMap<>();
					hm.put("message", "User created");
					return hm;
				}else {
					throw new TechRingException(TechRingApplicationErrors.USER_NOT_CREATED);
				}
			}
			else {
				throw new TechRingException(TechRingApplicationErrors.USER_NOT_CREATED);
			}
		}else {
			throw new TechRingException(TechRingApplicationErrors.USER_NAME_ALREADY_EXISTS);
		}
	}

	@Override
	public User getUsers(String id) {
		User user = userDao.findUserById(id);
		
		if(user == null) {
			throw new TechRingException(TechRingApplicationErrors.USER_CAN_NOT_FIND);
		}
		else {
			return user;
		}
	}

}
