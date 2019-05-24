package com.tech.ring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.User;


@Repository
public interface UserDao extends MongoRepository<User, String>{
	
	public User findByuserName(String userName);
}
