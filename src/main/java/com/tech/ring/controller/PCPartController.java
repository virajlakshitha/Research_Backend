package com.tech.ring.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.PCPart;
import com.tech.ring.request.PCPartRequest;
import com.tech.ring.response.TechRingResponse;
import com.tech.ring.service.PCPartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api-techRing/pcparts")
public class PCPartController {

	@Autowired
	PCPartService pcpartService;
	
	@RequestMapping(method = RequestMethod.POST , value = "")
	public TechRingResponse createPCPart(@RequestBody PCPartRequest pcpartRequest) {
		
		HashMap<String, String> hm = pcpartService.createNewPCPart(pcpartRequest);
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(hm);
		
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/{category}/{name}")
	public TechRingResponse getPCPart(@RequestBody String name, String category) {
		
		PCPart hm = pcpartService.getPCPartsByName(name, category);
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(hm);
		
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "id/{category}/{id}")
	public TechRingResponse getPCPartById(@RequestBody String id, String category) {
		
		PCPart hm = pcpartService.getPCPartsById(id, category);
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(hm);
		
		return techRingResponse;
	}
}
