package com.tech.ring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Laptop;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.User;
import com.tech.ring.domain.Vga;
import com.tech.ring.request.NotificationRequest;
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
		
		HashMap<String, String> hm = pcpartService.createNewRam(pcpartRequest);
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(hm);
		
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/upload/{path}")
	public TechRingResponse uploadPCPart(@PathVariable String path) {
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		boolean res = true;
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(res);
		
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/{category}/byName/{name}")
	public TechRingResponse getPCPart(@PathVariable("category") String category, @PathVariable("name") String name) {
		
		List<Ram> ram = null;
		List<Vga> vga = null;
		List<Cpu> cpu = null;
		List<Motherboard> motherboard = null;
		List<Hard_disk> hard_disk = null;
		TechRingResponse techRingResponse = new TechRingResponse();
		
		System.out.println("----------->" +category);
		
		if(category.equals("ram")) {
			ram = pcpartService.getRamPartsByName(name);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(ram);
		}
		else if(category.equals("vga")) {
			vga = pcpartService.getVgaPartsByName(name);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(vga);
		}
		else if(category.equals("cpu")) {
			cpu = pcpartService.getCpuPartsByName(name);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(cpu);
		}
		else if(category.equals("motherboard")) {
			motherboard = pcpartService.getMotherboardPartsByName(name);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(motherboard);
		}
		else if(category.equals("hard_disk")) {
			hard_disk = pcpartService.getHardDiskPartsByName(name);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(hard_disk);
		}
		
		return techRingResponse;
	}
	
	 
	@RequestMapping(method = RequestMethod.GET , value = "/ram/all")
	public TechRingResponse getPCParsAll() {
		
		List<Ram> ram = pcpartService.getRamParts();
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(ram);
		
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/{category}/byId/{id}")
	public TechRingResponse getPCPartById(@PathVariable("category") String category, @PathVariable("id") String id) {
		
		Ram ram = null;
		Vga vga = null;
		Cpu cpu = null;
		Motherboard motherboard = null;
		Hard_disk hard_disk = null;
		TechRingResponse techRingResponse = new TechRingResponse();
		
		if(category.equals("ram")) {
			ram = pcpartService.getRamPartsById(id);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(ram);
		}
		else if(category.equals("vga")) {
			vga = pcpartService.getVgaPartsById(id);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(vga);
		}
		else if(category.equals("cpu")) {
			cpu = pcpartService.getCpuPartsById(id);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(cpu);
		}
		else if(category.equals("motherboard")) {
			motherboard = pcpartService.getMotherboardPartsById(id);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(motherboard);
		}
		else if(category.equals("hard_disk")) {
			hard_disk = pcpartService.getHardDiskPartsById(id);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(hard_disk);
		}
		
		return techRingResponse;
	}

	@RequestMapping(method = RequestMethod.GET , value = "/getVendorPrices/{category}/{name}")
	public TechRingResponse getVendorPrices(@PathVariable("category") String category, @PathVariable("name") String name) {
		
		List<Ram> ram = null;
		List<Vga> vga = null;
		List<Cpu> cpu = null;
		List<Motherboard> motherboard = null;
		List<Hard_disk> hard_disk = null;
		
		TechRingResponse techRingResponse = new TechRingResponse();
		
		if(category.equals("ram")) {
			ram = pcpartService.getRamPartsByName(name);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(ram);
		}
		else if(category.equals("vga")) {
			vga = pcpartService.getVgaPartsByName(name);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(vga);
		}
		else if(category.equals("cpu")) {
			cpu = pcpartService.getCpuPartsByName(name);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(cpu);
		}
		else if(category.equals("motherboard")) {
			motherboard = pcpartService.getMotherboardPartsByName(name);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(motherboard);
		}
		else if(category.equals("hard_disk")) {
			hard_disk = pcpartService.getHardDiskPartsByName(name);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(hard_disk);
		}
		
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/vendors/{category}/{pro_name}")
	public TechRingResponse getVendorDetails(@PathVariable("category") String category, @PathVariable("pro_name") String pro_name) {
		TechRingResponse techRingResponse = new TechRingResponse();
		List<User> users = pcpartService.getVendorsForProduct(category, pro_name);
		
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(users);
		
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/notify")
	public TechRingResponse pushNotification(@RequestBody NotificationRequest notificationRequest) {
		TechRingResponse techRingResponse = new TechRingResponse();
		
		HashMap<String, String> hm = pcpartService.pushNotification(notificationRequest);
		techRingResponse.setResponseCode("111");
		
		return techRingResponse;
	} 
	
}
