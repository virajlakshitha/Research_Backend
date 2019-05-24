package com.tech.ring.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.ring.domain.LaptopBrands;
import com.tech.ring.enums.TechRingApplicationErrors;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.repository.LaptopBrandDao;
import com.tech.ring.request.LaptopBrandRequest;

@Service
public class LaptopBrandServiceImpl implements LaptopBrandService{
	
	@Autowired
	LaptopBrandDao laptopBrandDao; 

	@Override
	public HashMap<String, String> createNewBrand(LaptopBrandRequest laptopBrandRequest) {
		
		LaptopBrands laptopBrands = laptopBrandDao.findByLapBrandName(laptopBrandRequest.getLapBrandName());
		
		if(laptopBrands == null) {
			
			LaptopBrands newLaptopBrand = new LaptopBrands();
			newLaptopBrand.setLapBrandName(laptopBrandRequest.getLapBrandName());
			
			LaptopBrands result = laptopBrandDao.saveLaptopBrand(newLaptopBrand);
			
			if(result != null) {
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("message", "Laptop rand created successfully");
				return hm;
			}
			else {
				throw new TechRingException(TechRingApplicationErrors.LAPTOP_ALLREADY_EXISTS);
			}
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.LAPTOP_BRAND_NAME_ALREADY_EXISTS);
		}
	}

	@Override
	public List<LaptopBrands> getAllLaptopBrands() {
		
		List<LaptopBrands> brands = laptopBrandDao.findAllBrands();
		
		if(brands != null  && !brands.isEmpty()) {
			return brands;
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.LAPTOP_BRAND_NOT_FOUND);
		}
	}

}
