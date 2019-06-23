package com.tech.ring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			throw new TechRingException(TechRingApplicationErrors.GAME_NOT_FOUND);
		}
	}

	@Override
	public Ram getRamUnderBudget(String id, String min, String max) {
		Ram ram = buildForPriceDao.findRam(id, min, max);
		
		if(ram != null) {
			return ram;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.GAME_NOT_FOUND);
		}
	}

	@Override
	public Vga getVgaUnderBudget(String id, String min, String max) {
		Vga vga = buildForPriceDao.findVga(id, min, max);
		
		if(vga != null) {
			return vga;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.GAME_NOT_FOUND);
		}
	}

	@Override
	public Cpu getCpuUnderBudget(String id, String min, String max) {
		Cpu cpu = buildForPriceDao.findCpu(id, min, max);
		
		if(cpu != null) {
			return cpu;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.GAME_NOT_FOUND);
		}
	}

	@Override
	public Motherboard getMotherboardUnderBudget(String id, String min, String max) {
		Motherboard Motherboard = buildForPriceDao.findMotherboard(id, min, max);
		
		if(Motherboard != null) {
			return Motherboard;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.GAME_NOT_FOUND);
		}
	}

	@Override
	public Hard_disk getHardDiskUnderBudget(String id, String min, String max) {
		Hard_disk hard_disk = buildForPriceDao.findHard_disk(id, min, max);
		
		if(hard_disk != null) {
			return hard_disk;
		}
		
		else {
			throw new TechRingException(TechRingApplicationErrors.GAME_NOT_FOUND);
		}
	}

}
