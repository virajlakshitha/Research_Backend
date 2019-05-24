package com.tech.ring.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.ring.domain.Laptop;
import com.tech.ring.enums.TechRingApplicationErrors;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.repository.LaptopDao;
import com.tech.ring.request.LaptopRequest;

@Service
public class LaptopServiceImpl implements LaptopService{

	@Autowired
	LaptopDao laptopDao;
	
	@Override
	public HashMap<String, String> creteNewLaptop(LaptopRequest laptopRequest) {
		
		Laptop laptop = laptopDao.findByLapName(laptopRequest.getLapName());
		
		if(laptop == null) {
			
			Laptop newLaptop = new Laptop();
			
			newLaptop.setLapName(laptopRequest.getLapName());
			newLaptop.setLapBrand(laptopRequest.getLapBrand());
			newLaptop.setCpuModel(laptopRequest.getCpuModel());
			newLaptop.setCpuCoresSize(laptopRequest.getCpuCoresSize());
			newLaptop.setCpuCachSize(laptopRequest.getCpuCachSize());
			newLaptop.setCpuBoostSpeed(laptopRequest.getCpuBoostSpeed());
			newLaptop.setRamType(laptopRequest.getRamType());
			newLaptop.setRamSize(laptopRequest.getRamSize());
			newLaptop.setStorageType(laptopRequest.getStorageType());
			newLaptop.setStorageSize(laptopRequest.getStorageSize());
			newLaptop.setBatteryType(laptopRequest.getBatteryType());
			newLaptop.setBatteryCapacity(laptopRequest.getBatteryCapacity());
			newLaptop.setGpuMemorySize(laptopRequest.getGpuMemorySize());
			newLaptop.setGpuBooStSpeed(laptopRequest.getGpuBooStSpeed());
			
			Laptop lapTopResult = laptopDao.saveLaptop(newLaptop);
			
			if(lapTopResult != null) {
			
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("message", "laptop created");
				return hm;
			}
			else {
				throw new TechRingException(TechRingApplicationErrors.LAPTOP_NOT_CREATED);
			}
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.LAPTOP_ALLREADY_EXISTS);
		}
				
	}

}
