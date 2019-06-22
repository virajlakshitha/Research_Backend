package com.tech.ring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.request.PCPartRequest;
import com.tech.ring.response.TechRingResponse;
import com.tech.ring.service.PCPartService;

@RestController
@RequestMapping(value = "/api-techRing/pcparts")
public class PCPartController {
	
	@Autowired
	PCPartService pcpartService;
	
	@RequestMapping(method = RequestMethod.POST , value = "/create")
	public TechRingResponse createPCPart(@RequestBody PCPartRequest pcpartRequest) {
		
		HashMap<String, String> hm = pcpartService.createNewPCPart(pcpartRequest);
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(hm);
		
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/{category}/byName/{name}")
	public String getPCPart(@RequestParam String name, String category) {
		
		String Path = "python C:\\Users\\viraj\\Desktop\\Test\\JavaApplication10\\src\\javaapplication10\\abc.py";
		String ret = "";
		try {
            Process p = Runtime.getRuntime().exec(Path);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            ret = in.readLine();
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
		return ret;
	}

	@RequestMapping(method = RequestMethod.GET , value = "/getVendorPrices/{name}")
	public String getVendorPrices(@RequestParam String name) {
		
		String Path = "python C:\\Users\\viraj\\Desktop\\Test\\JavaApplication10\\src\\javaapplication10\\abc.py";
		String ret = "";
		try {
            String cc="hello";
            Process p = Runtime.getRuntime().exec(Path+cc);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            ret = in.readLine();
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
		return ret;
	}
}