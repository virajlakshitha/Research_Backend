package com.tech.ring.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.ring.domain.BuildSequence;
import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Game;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;
import com.tech.ring.enums.TechRingApplicationErrors;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.repository.BuildForPriceDao;

@Service
public class BuildForPriceServiceImpl implements BuildForPriceService {
	
	@Autowired
	BuildForPriceDao buildForPriceDao;

	@Override
	public List<Ram> getAll() {
		List<Ram> ram = buildForPriceDao.findAll();
		
		if(ram != null && !ram.isEmpty()) {
			return ram;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Ram> getRamUnderBudget(Double min, Double max) {
		List<Ram> ram = buildForPriceDao.findRam(min, max);
		
		if(ram != null) {
			return ram;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Vga> getVgaUnderBudget(Double min, Double max) {
		List<Vga> vga = buildForPriceDao.findVga(min, max);
		
		if(vga != null) {
			return vga;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Cpu> getCpuUnderBudget(Double min, Double max) {
		List<Cpu> cpu = buildForPriceDao.findCpu(min, max);
		
		if(cpu != null) {
			return cpu;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Motherboard> getMotherboardUnderBudget(Double min, Double max) {
		List<Motherboard> Motherboard = buildForPriceDao.findMotherboard(min, max);
		
		if(Motherboard != null) {
			return Motherboard;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Hard_disk> getHardDiskUnderBudget(Double min, Double max) {
		List<Hard_disk> hard_disk = buildForPriceDao.findHard_disk(min, max);
		
		if(hard_disk != null) {
			return hard_disk;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<BuildSequence> budget_plan(Double min, Double max) {
		List<BuildSequence> list = buildForPriceDao.budget_plan(min, max);
		
		if(list != null) {
			return list;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.BUILD_SEQUENCE_NOT_FOUND);
		}
	}
	
	@Override
	public List<BuildSequence> budget_plan_price(String category, Double min, Double max) {
		List<BuildSequence> list = buildForPriceDao.budget_plan(min, max);
		
		if(list != null) {
			return list;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.BUILD_SEQUENCE_NOT_FOUND);
		}
	}

	@Override
	public HashMap<String, Double> getMaxMinBudget() {
		HashMap<String, Double> list = buildForPriceDao.getMaxMinBudget();
		
		if(list != null) {
			return list;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.CAN_NOT_FIND_MATCHING_RESULT);
		}
	}

}
