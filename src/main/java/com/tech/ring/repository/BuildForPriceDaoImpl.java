package com.tech.ring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Game;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;

@Repository
public class BuildForPriceDaoImpl implements BuildForPriceDao{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Ram> findAll() {
		try {
			
			return mongoTemplate.findAll(Ram.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Ram findRam(String min, String max) {
		try {
			double range = ((Integer.parseInt(max)-Integer.parseInt(min))*10/100);
			Query query = new Query();
			query.addCriteria(Criteria.where("price").lt(range));
			
			return mongoTemplate.findOne(query, Ram.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Vga findVga(String min, String max) {
		try {
			double range = ((Integer.parseInt(max)-Integer.parseInt(min))*20/100);
			Query query = new Query();
			query.addCriteria(Criteria.where("price").lt(range));
			
			return mongoTemplate.findOne(query, Vga.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Cpu findCpu(String min, String max) {
		try {
			double range = ((Integer.parseInt(max)-Integer.parseInt(min))*20/100);
			Query query = new Query();
			query.addCriteria(Criteria.where("price").lt(range));
			
			return mongoTemplate.findOne(query, Cpu.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Motherboard findMotherboard(String min, String max) {
		try {
			double range = ((Integer.parseInt(max)-Integer.parseInt(min))*20/100);
			Query query = new Query();
			query.addCriteria(Criteria.where("price").lt(range));
			
			return mongoTemplate.findOne(query, Motherboard.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Hard_disk findHard_disk(String min, String max) {
		try {
			double range = ((Integer.parseInt(max)-Integer.parseInt(min))*20/100);
			Query query = new Query();
			query.addCriteria(Criteria.where("price").lt(range));
			
			return mongoTemplate.findOne(query, Hard_disk.class);
			
		} catch (Exception e) {
			return null;
		}
	}

}
