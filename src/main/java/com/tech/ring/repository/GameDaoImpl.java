package com.tech.ring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.Game;
import com.tech.ring.domain.Laptop;
import com.tech.ring.domain.LaptopBrands;

@Repository
public class GameDaoImpl implements GameDao{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Game findByGameName(String gameName) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(gameName));
			
			return mongoTemplate.findOne(query, Game.class);
			
		} catch (Exception e) {
			return null;
		} 
	}

	@Override
	public Game SaveGame(Game newGame) {
		try {
					
		mongoTemplate.save(newGame);
		return newGame;
					
		} catch (Exception e) {
			return null;
		} 
	}

	@Override
	public List<Game> findAllGames() {
		try {
			
			return mongoTemplate.findAll(Game.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Game findById(String id) {
		try {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			return mongoTemplate.findOne(query, Game.class);
		} catch (Exception e) {
			return null;
		}
	}

}
