package com.tech.ring.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.Laptop;

@Repository
public class LaptopDaoImpl implements LaptopDao{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Laptop findByLapName(String lapName) {
		
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("lapName").is(lapName));
			
			return mongoTemplate.findOne(query, Laptop.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Laptop saveLaptop(Laptop laptop) {

		try {
			mongoTemplate.save(laptop);
			return laptop;
		} catch (Exception e) {
			
			return null;
		}
	}

}
