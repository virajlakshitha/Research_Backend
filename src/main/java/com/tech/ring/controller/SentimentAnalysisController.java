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
	
	@RequestMapping(method = RequestMethod.GET , value = "")
	public TechRingResponse createPCPart() {
		
		List<Comments> comments = new ArrayList<Comments>();
		try {
			//Path to the csv file
			String csvFile = "C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Python\\fb.csv";
			String line = "";
	        String cvsSplitBy = ",";
	        
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	            while ((line = br.readLine()) != null) {
	            	System.out.println(line);
	                String[] list = line.split(cvsSplitBy);
	                Comments comment = new Comments();
	                for(int i=0; i<list.length ; i++) {
	                	if(i==0) {
	                		comment.setComment_name(list[i]);
	                	}
	                	else if(i==1) {
	                		comment.setComment(list[i]);
	                	}
	                	else if(i==2) {
	                		comment.setComment_pic(list[i]);
	                	}
	                }
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
