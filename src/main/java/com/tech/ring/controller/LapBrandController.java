package com.tech.ring.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.LaptopBrands;
import com.tech.ring.request.LaptopBrandRequest;
import com.tech.ring.response.TechRingResponse;
import com.tech.ring.service.LaptopBrandService;

@RestController
@RequestMapping(value = "/api-techRing/lapBrands")
public class LapBrandController {
	
	@Autowired
	LaptopBrandService laptopBrandService;
	
	/*
	 * Added new laptop brand 
	 */
	@RequestMapping(method = RequestMethod.POST , value = "/create")
	public TechRingResponse createLapBrand(@RequestBody LaptopBrandRequest laptopBrandRequest) {
		
		HashMap<String, String> laptopBrands = laptopBrandService.createNewBrand(laptopBrandRequest);
		
		TechRingResponse response = new TechRingResponse();
		response.setResponseCode("111");
		response.setResponseObject(laptopBrands);
		
		return response;
	}
	
	/*
	 * Get all laptop brand 
	 */
	@RequestMapping(method = RequestMethod.GET , value = "/getAll")
	public TechRingResponse findLaptopBrands() {
		
		List<LaptopBrands> laptopBrands = laptopBrandService.getAllLaptopBrands();
		
		TechRingResponse response = new TechRingResponse();
		response.setResponseCode("111");
		response.setResponseObject(laptopBrands);
		
		return response;
	}
}
