package com.tech.ring.service;

import java.util.HashMap;
import java.util.List;

import com.tech.ring.domain.Laptop;
import com.tech.ring.request.LaptopRequest;

public interface LaptopService {
	
	public HashMap<String, String> creteNewLaptop(LaptopRequest laptopRequest);
	public List<Laptop> getLaptopByBrandWise(String key);
}
