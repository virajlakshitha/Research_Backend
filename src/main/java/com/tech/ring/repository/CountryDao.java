package com.tech.ring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.Country;


@Repository
public interface CountryDao extends MongoRepository<Country, String>{
	
	public Country findByName(String name);
}
