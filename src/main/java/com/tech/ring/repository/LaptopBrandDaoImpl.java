package com.tech.ring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.LaptopBrands;

@Repository
public class LaptopBrandDaoImpl implements LaptopBrandDao{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public LaptopBrands findByLapBrandName(String lapBrandName) {

		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("lapBrandName").is(lapBrandName));
			
			return mongoTemplate.findOne(query, LaptopBrands.class);
			
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public LaptopBrands saveLaptopBrand(LaptopBrands laptopBrands) {

		try {
			
			mongoTemplate.save(laptopBrands);
			return laptopBrands;
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public List<LaptopBrands> findAllBrands() {

		try {
			
			return mongoTemplate.findAll(LaptopBrands.class);
			
		} catch (Exception e) {
			return null;
		}
	}

}
