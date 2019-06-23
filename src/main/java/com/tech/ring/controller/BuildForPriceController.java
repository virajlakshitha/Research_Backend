package com.tech.ring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Game;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;
import com.tech.ring.request.PCPartRequest;
import com.tech.ring.response.TechRingResponse;
import com.tech.ring.service.BuildForPriceService;
import com.tech.ring.service.PCPartService;

@RestController
@RequestMapping(value = "/api-techRing/build_for_price")
public class BuildForPriceController {
	
	@Autowired
	BuildForPriceService buildForPriceService;
	
	@RequestMapping(method = RequestMethod.GET , value = "change/{category}/{id}/{min}/{max}")
	public TechRingResponse changePCPart(@PathVariable("category") String category, @PathVariable("id") String id, @PathVariable("min") String min, @PathVariable("max") String max) {
		
//		String Path = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Python\\Search_products_v1.py";
//		String ret = "";
//		try {
//            Process p = Runtime.getRuntime().exec(Path);
//            
//            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            ret = in.readLine();
//        } catch (IOException ex) {
//        	ex.printStackTrace();
//        }
//		return ret;
		Ram ram = null;
		Vga vga = null;
		Cpu cpu = null;
		Motherboard motherboard = null;
		Hard_disk hard_disk = null;
		TechRingResponse techRingResponse = new TechRingResponse();
		
		if(category.equals("ram")) {
			ram = buildForPriceService.getRamUnderBudget(id,min,max);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(ram);
		}
		else if(category.equals("vga")) {
			vga = buildForPriceService.getVgaUnderBudget(id,min,max);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(vga);
		}
		else if(category.equals("cpu")) {
			cpu = buildForPriceService.getCpuUnderBudget(id,min,max);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(cpu);
		}
		else if(category.equals("motherboard")) {
			motherboard = buildForPriceService.getMotherboardUnderBudget(id,min,max);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(motherboard);
		}
		else if(category.equals("hard_disk")) {
			hard_disk = buildForPriceService.getHardDiskUnderBudget(id,min,max);
			techRingResponse.setResponseCode("111");
			techRingResponse.setResponseObject(hard_disk);
		}
		
		return techRingResponse;
		
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "different_plan/{min}/{max}")
	public TechRingResponse differentPlan(@PathVariable("category") String category, @PathVariable("min") String min, @PathVariable("max") String max) {
		
		
		return null;
	}

}
