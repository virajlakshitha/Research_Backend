package com.tech.ring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;
import com.tech.ring.domain.BuildSequence;

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
	public List<Ram> findRam(Double min, Double max) {
		try {
			String max_limit = Double.toString(max*10/100);
			String min_limit = Double.toString(min*10/100);
			Query query = new Query();
			query.addCriteria(Criteria.where("price").lte(max_limit).andOperator(Criteria.where("price").gte(min_limit))).with(new Sort(Sort.Direction.ASC, "points"));
			
			return mongoTemplate.find(query, Ram.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Vga> findVga(Double min, Double max) {
		try {
			String max_limit = Double.toString(max*20/100);
			String min_limit = Double.toString(min*20/100);
			Query query = new Query();
			query.addCriteria(Criteria.where("price").lte(max_limit).andOperator(Criteria.where("price").gte(min_limit))).with(new Sort(Sort.Direction.ASC, "points"));
			
			return mongoTemplate.find(query, Vga.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Cpu> findCpu(Double min, Double max) {
		try {
			String max_limit = Double.toString(max*20/100);
			String min_limit = Double.toString(min*20/100);
			Query query = new Query();
			query.addCriteria(Criteria.where("price").lte(max_limit).andOperator(Criteria.where("price").gte(min_limit))).with(new Sort(Sort.Direction.ASC, "points"));
			return mongoTemplate.find(query, Cpu.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Motherboard> findMotherboard(Double min, Double max) {
		try {
			String max_limit = Double.toString(max*10/100);
			String min_limit = Double.toString(min*10/100);
			Query query = new Query();
			query.addCriteria(Criteria.where("price").lte(max_limit).andOperator(Criteria.where("price").gte(min_limit))).with(new Sort(Sort.Direction.ASC, "points"));
			
			return mongoTemplate.find(query, Motherboard.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Hard_disk> findHard_disk(Double min, Double max) {
		try {
			String max_limit = Double.toString(max*10/100);
			String min_limit = Double.toString(min*10/100);
			Query query = new Query();
			query.addCriteria(Criteria.where("price").lte(max_limit).andOperator(Criteria.where("price").gte(min_limit))).with(new Sort(Sort.Direction.ASC, "points"));
			
			return mongoTemplate.find(query, Hard_disk.class);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<BuildSequence> budget_plan(Double min, Double max) {
		try {
			String ram_min = Double.toString(min*10/100);
			String ram_max = Double.toString(max*10/100);
			String vga_min = Double.toString(min*20/100);
			String vga_max = Double.toString(max*20/100);
			String cpu_min = Double.toString(min*20/100);
			String cpu_max = Double.toString(max*20/100);
			String motherboard_min = Double.toString(min*10/100);
			String motherboard_max = Double.toString(max*10/100);
			String hardDisk_min = Double.toString(min*10/100);
			String hardDisk_max = Double.toString(max*10/100);
			
			Query ram_query = new Query();
			ram_query.addCriteria(Criteria.where("price").lte(ram_max).andOperator(Criteria.where("price").gte(ram_min))).with(new Sort(Sort.Direction.ASC, "points"));
			List<Ram> rams = mongoTemplate.find(ram_query, Ram.class);
			Query vga_query = new Query();
			vga_query.addCriteria(Criteria.where("price").lte(vga_max).andOperator(Criteria.where("price").gte(vga_min))).with(new Sort(Sort.Direction.ASC, "points"));
			List<Vga> vgas = mongoTemplate.find(vga_query, Vga.class);
			Query cpu_query = new Query();
			cpu_query.addCriteria(Criteria.where("price").lte(cpu_max).andOperator(Criteria.where("price").gte(cpu_min))).with(new Sort(Sort.Direction.ASC, "points"));
			List<Cpu> cpus = mongoTemplate.find(cpu_query, Cpu.class);
			Query motherboard_query = new Query();
			motherboard_query.addCriteria(Criteria.where("price").lte(motherboard_max).andOperator(Criteria.where("price").gte(motherboard_min))).with(new Sort(Sort.Direction.ASC, "points"));
			List<Motherboard> mths = mongoTemplate.find(motherboard_query, Motherboard.class);
			Query hardDisk_query = new Query();
			hardDisk_query.addCriteria(Criteria.where("price").lte(hardDisk_max).andOperator(Criteria.where("price").gte(hardDisk_min))).with(new Sort(Sort.Direction.ASC, "points"));
			List<Hard_disk> hds = mongoTemplate.find(hardDisk_query, Hard_disk.class);
			
			List<BuildSequence> list = new ArrayList<BuildSequence>();
			for(int i=0 ; i<2 ; i++) {
				Ram ram = rams.get(i);
				Vga vga = vgas.get(i);
				Cpu cpu = cpus.get(i);
				Motherboard mth = mths.get(i);
				Hard_disk hd = hds.get(i);
				BuildSequence bs = new BuildSequence(ram, vga, cpu, mth, hd);
				list.add(bs);
			}
			return list;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<BuildSequence> budget_plan_price(String category, Double min, Double max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Double> getMaxMinBudget() {
		Double min = 0.00;
		Double max = 0.00;
		HashMap<String, Double> budget = new HashMap<String, Double>();
		try {
			final Pageable pageableRequest = PageRequest.of(0, 1);
			Query ram_query_min = new Query();
			ram_query_min.with(new Sort(Sort.Direction.ASC, "price"));
			ram_query_min.with(pageableRequest);
			Ram ram = (Ram) mongoTemplate.findOne(ram_query_min,Ram.class);
			min += Double.parseDouble(ram.getPrice());
			Query ram_query_max = new Query();
			ram_query_max.with(new Sort(Sort.Direction.DESC, "price"));
			ram_query_max.with(pageableRequest);
			ram = (Ram) mongoTemplate.findOne(ram_query_max,Ram.class);
			max += Double.parseDouble(ram.getPrice());
			
			Query vga_query_min = new Query();
			vga_query_min.with(new Sort(Sort.Direction.ASC, "price"));
			vga_query_min.with(pageableRequest);
			Vga vga = (Vga) mongoTemplate.findOne(vga_query_min,Vga.class);
			min += Double.parseDouble(vga.getPrice());
			Query vga_query_max = new Query();
			vga_query_max.with(new Sort(Sort.Direction.DESC, "price"));
			vga_query_max.with(pageableRequest);
			vga = (Vga) mongoTemplate.findOne(vga_query_max,Vga.class);
			max += Double.parseDouble(vga.getPrice());
			
			Query cpu_query_min = new Query();
			cpu_query_min.with(new Sort(Sort.Direction.ASC, "price"));
			cpu_query_min.with(pageableRequest);
			Cpu cpu = (Cpu) mongoTemplate.findOne(cpu_query_min,Cpu.class);
			min += Double.parseDouble(cpu.getPrice());
			Query cpu_query_max = new Query();
			cpu_query_max.with(new Sort(Sort.Direction.DESC, "price"));
			cpu_query_max.with(pageableRequest);
			cpu = (Cpu) mongoTemplate.findOne(cpu_query_max,Cpu.class);
			max += Double.parseDouble(cpu.getPrice());
			
			Query motherboard_query_min = new Query();
			motherboard_query_min.with(new Sort(Sort.Direction.ASC, "price"));
			motherboard_query_min.with(pageableRequest);
			Motherboard motherboard = (Motherboard) mongoTemplate.findOne(motherboard_query_min,Motherboard.class);
			min += Double.parseDouble(motherboard.getPrice());
			Query motherboard_query_max = new Query();
			motherboard_query_max.with(new Sort(Sort.Direction.DESC, "price"));
			motherboard_query_max.with(pageableRequest);
			motherboard = (Motherboard) mongoTemplate.findOne(motherboard_query_max,Motherboard.class);
			max += Double.parseDouble(motherboard.getPrice());
			
			Query hardDisk_query_min = new Query();
			hardDisk_query_min.with(new Sort(Sort.Direction.ASC, "price"));
			hardDisk_query_min.with(pageableRequest);
			Hard_disk hard_disk = (Hard_disk) mongoTemplate.findOne(hardDisk_query_min,Hard_disk.class);
			min += Double.parseDouble(hard_disk.getPrice());
			Query hardDisk_query_max = new Query();
			hardDisk_query_max.with(new Sort(Sort.Direction.DESC, "price"));
			hardDisk_query_max.with(pageableRequest);
			hard_disk = (Hard_disk) mongoTemplate.findOne(hardDisk_query_max,Hard_disk.class);
			max += Double.parseDouble(hard_disk.getPrice());
			
			budget.put("min", min);
			budget.put("max", max);
			return budget;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
