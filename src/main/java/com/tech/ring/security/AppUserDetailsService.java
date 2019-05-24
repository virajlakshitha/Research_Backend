package com.tech.ring.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.ring.domain.User;
import com.tech.ring.enums.TechRingApplicationErrors;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.repository.UserDao;



@Service
public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.findByuserName(username);
		if(user == null) {
			throw new TechRingException(TechRingApplicationErrors.USER_NAME_NOT_FOUND);
		}
		
		return UserPrincipal.create(user);
	}
		
	@Transactional
	public UserDetails loadUserById(String id) {
		Optional<User> user = userDao.findById(id);
		
		if(!user.isPresent()) {
			throw new TechRingException(TechRingApplicationErrors.USER_NAME_NOT_FOUND);
		}
		
		return UserPrincipal.create(user.get());
	}
}
