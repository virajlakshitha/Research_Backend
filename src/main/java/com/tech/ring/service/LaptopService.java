package com.tech.ring.service;

import java.util.HashMap;

import com.tech.ring.request.LaptopRequest;

public interface LaptopService {
	
	public HashMap<String, String> creteNewLaptop(LaptopRequest laptopRequest);
}
