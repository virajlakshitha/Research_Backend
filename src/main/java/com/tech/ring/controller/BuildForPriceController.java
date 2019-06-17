package com.tech.ring.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.PCPart;
import com.tech.ring.response.TechRingResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api-techRing/build-for-price")
public class BuildForPriceController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{min}/{max}")
	public TechRingResponse buildForPrice(@RequestBody double min, double max) {

		return null;
		
	}

}
