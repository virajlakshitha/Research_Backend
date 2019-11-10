package com.tech.ring.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.User;
import com.tech.ring.request.UserSignInRequest;
import com.tech.ring.request.UserSignUpRequest;
import com.tech.ring.response.JwtAuthenticationResponse;
import com.tech.ring.response.TechRingResponse;
import com.tech.ring.security.JwtTokenProvider;
import com.tech.ring.service.UserService;



@RestController
@RequestMapping(value = "/api-techRing/auth")
public class UserAuthController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	AuthenticationManager am;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/create/customer" , method = RequestMethod.POST)
	public TechRingResponse userSignUpCustomer(@RequestBody UserSignUpRequest userSignUpRequest) {
		
		HashMap<String, String> hm = userService.userSignUp(userSignUpRequest, "customer");
		
		TechRingResponse mongoResponse = new TechRingResponse();
		mongoResponse.setResponseCode("111");
		mongoResponse.setResponseObject(hm);
		
		return mongoResponse;
	}
	
	@RequestMapping(value = "/create/vendor" , method = RequestMethod.POST)
	public TechRingResponse userSignUpVendor(@RequestBody UserSignUpRequest userSignUpRequest) {
		
		HashMap<String, String> hm = userService.userSignUp(userSignUpRequest, "vendor");
		
		TechRingResponse mongoResponse = new TechRingResponse();
		mongoResponse.setResponseCode("111");
		mongoResponse.setResponseObject(hm);
		
		return mongoResponse;
	}
	
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public TechRingResponse userLogin(@RequestBody UserSignInRequest userSignInRequest) {
		
//		Authentication authentication = am.authenticate(new UsernamePasswordAuthenticationToken(
//				userSignInRequest.getUsername() , passwordEncoder.encode(userSignInRequest.getPassword())));
//		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		String token = jwtTokenProvider.generateToken(authentication);
//		
		TechRingResponse response = new TechRingResponse();
		response.setResponseCode("111");
//		response.setResponseObject(new JwtAuthenticationResponse(token));
//		System.out.println(token);
		return response;
	}
	
	@RequestMapping(value = "/users/{id}" , method = RequestMethod.GET)
	public TechRingResponse getUserDetails(@PathVariable("id") String id) {
		
		User hm = userService.getUsers(id);
		
		TechRingResponse mongoResponse = new TechRingResponse();
		mongoResponse.setResponseCode("111");
		mongoResponse.setResponseObject(hm);
		
		return mongoResponse;
	}
}
