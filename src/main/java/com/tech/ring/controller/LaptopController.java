package com.tech.ring.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.Laptop;
import com.tech.ring.request.LaptopRequest;
import com.tech.ring.response.TechRingResponse;
import com.tech.ring.service.LaptopService;

@RestController
@RequestMapping(value = "/api-techRing/laptops")
public class LaptopController {
	
	@Autowired
	LaptopService laptopService;
	
	
	/*
	 * Add new laptop 
	 */
	@RequestMapping(method = RequestMethod.POST , value = "/create")
	public TechRingResponse createLaptop(@RequestBody LaptopRequest laptopRequest) {
		
		HashMap<String, String> hm = laptopService.creteNewLaptop(laptopRequest);
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(hm);
		
		return techRingResponse;
	}
	
	/*
	 * Get all Laptop Brand Wise
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET , value = "/{key}/search")
	public TechRingResponse findLaptopsByKeyWord(@PathVariable("key") String key) {
		
		List<Laptop> laptops = laptopService.getLaptopByBrandWise(key);
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(laptops);
		
		return techRingResponse;
	}
}
