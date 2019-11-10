package com.tech.ring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public User findUser(String username, String password) {

		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("userName").is(username).and("password").is(password));
			
			return mongoTemplate.findOne(query, User.class);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public User saveUser(User user) {

		try {
			mongoTemplate.save(user);
			return user;
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public User findUserById(String id) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			
			return mongoTemplate.findOne(query, User.class);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public User findByuserName(String username) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("userName").is(username));
			return mongoTemplate.findOne(query, User.class);
		} catch(Exception e) {
			return null;
		}
		
	}
	
	

}
