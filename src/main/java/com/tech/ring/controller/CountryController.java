package com.tech.ring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.Country;
import com.tech.ring.request.CountryRequest;
import com.tech.ring.response.TechRingResponse;
import com.tech.ring.service.CountryService;



@RestController
@RequestMapping(value = "/api/country")
public class CountryController {
	
	@Autowired
	CountryService countryService; 
	
	@RequestMapping(value = "/create" , method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_USER')")
	public TechRingResponse createCountry(@RequestBody CountryRequest countryRequest) {
		
		Country result = countryService.createCountry(countryRequest);
		
		TechRingResponse mongoResponse = new TechRingResponse();
		mongoResponse.setResponseCode("111");
		mongoResponse.setResponseObject(result);
		
		return mongoResponse;
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public TechRingResponse getCountryById(@PathVariable String id) {
		
		Country country = countryService.countryFindById(id);
		
		TechRingResponse mongoResponse = new TechRingResponse();
		mongoResponse.setResponseCode("111");
		mongoResponse.setResponseObject(country);
		
		return mongoResponse;
	}
}
