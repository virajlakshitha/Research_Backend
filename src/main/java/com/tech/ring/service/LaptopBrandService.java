package com.tech.ring.service;

import java.util.HashMap;
import java.util.List;

import com.tech.ring.domain.LaptopBrands;
import com.tech.ring.request.LaptopBrandRequest;

public interface LaptopBrandService {
	
	public HashMap<String, String> createNewBrand(LaptopBrandRequest laptopBrandRequest);
	public List<LaptopBrands> getAllLaptopBrands();
}
