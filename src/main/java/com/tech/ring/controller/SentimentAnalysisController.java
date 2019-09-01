package com.tech.ring.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.Comments;
import com.tech.ring.request.PCPartRequest;
import com.tech.ring.response.TechRingResponse;
import com.tech.ring.service.PCPartService;

@RestController
@RequestMapping(value = "/api-techRing/pcparts/comments")
public class SentimentAnalysisController {
	
	@RequestMapping(method = RequestMethod.GET , value = "/{name}")
	public TechRingResponse createPCPart(@PathVariable String name) {
		
		String Path = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Reasearh_Scripts\\price_optimization\\build_for_price\\fb.py";
		try {
			Process p = Runtime.getRuntime().exec(Path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Comments> comments = new ArrayList<Comments>();
		try {
			//Path to the csv file
			String csvFile = "C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Python\\fb.csv";
			String line = "";
	        String cvsSplitBy = ",";
	        
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	            while ((line = br.readLine()) != null) {
	                String[] list = line.split(cvsSplitBy);
	                Comments comment = new Comments(list[1], list[0], list[2]);
	                comments.add(comment);
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(comments);
		return techRingResponse;
	}
}
