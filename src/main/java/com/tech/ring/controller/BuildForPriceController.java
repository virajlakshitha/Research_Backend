package com.tech.ring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.PCPart;
import com.tech.ring.response.TechRingResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api-techRing/build-for-price")
public class BuildForPriceController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String findMaximum() {
		
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
	
	@RequestMapping(method = RequestMethod.GET, value = "change/{category}/{id}/{min}/{max}")
	public String changePCPart(@RequestParam String category, String id, double min, double max) {

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
	
	@RequestMapping(method = RequestMethod.GET, value = "range/{min}/{max}")
	public String findByPriceRange(@RequestParam double min, double max) {

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
	
	@RequestMapping(method = RequestMethod.GET, value = "different-plan/{min}/{max}")
	public String differentPlan(@RequestParam double min, double max) {

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

}
