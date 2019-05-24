package com.tech.ring.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.request.LaptopRequest;
import com.tech.ring.response.TechRingResponse;
import com.tech.ring.service.LaptopService;

@RestController
@RequestMapping(value = "/api-techRing/laptops")
public class LaptopController {
	
	@Autowired
	LaptopService laptopService;
	
	@RequestMapping(method = RequestMethod.POST , value = "/create")
	public TechRingResponse createLaptop(@RequestBody LaptopRequest laptopRequest) {
		
		HashMap<String, String> hm = laptopService.creteNewLaptop(laptopRequest);
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(hm);
		
		return techRingResponse;
	}
	
	public TechRingResponse displayLaptopsBrandWise() {
		
		return null;
	}
}
