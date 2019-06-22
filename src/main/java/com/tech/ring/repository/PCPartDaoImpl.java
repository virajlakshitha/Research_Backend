package com.tech.ring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.PCPart;

@Repository
public class PCPartDaoImpl implements PCPartDao{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public PCPart savePCPart(PCPart pcpart) {
		try {
			mongoTemplate.save(pcpart);
			return pcpart;
		} catch (Exception e) {
			
			return null;
		}
	}
	
	@Override
	public PCPart findByPartName(String partName) {
		
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(partName));
			
			return mongoTemplate.findOne(query, PCPart.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public PCPart findByPartByName(String partName, String category) {

		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(partName));
			
			return mongoTemplate.findOne(query, PCPart.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public PCPart findByPartById(String id, String category) {

		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			
			return mongoTemplate.findOne(query, PCPart.class);
			
		} catch (Exception e) {
			return null;
		}
	}

}
