package com.tech.ring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.domain.BuildSequence;
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
@RequestMapping(value = "/api-techRing/build_for_price/")
public class BuildForPriceController {
	
	@Autowired
	BuildForPriceService buildForPriceService;
	
	
	@RequestMapping(method = RequestMethod.GET , value = "budgetPlan/{min}/{max}")
	public TechRingResponse budget_plan(@PathVariable("min") Double min, @PathVariable("max") Double max) {
//		String Path = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Reasearh_Scripts\\price_optimization\\build_for_price\\Build_for_price.py "+min+" "+max;
//		String Path = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Reasearh_Scripts\\price_optimization\\build_for_price\\test_build_for_price.py "+min+" "+max;
		String Path = "python D:\\Tech-Ring-Team\\Reasearh_Scripts\\price_optimization\\build_for_price\\test_build_for_price.py "+min+" "+max;
		List<BuildSequence> list = new ArrayList<BuildSequence>();
        try {
        	Process p = Runtime.getRuntime().exec(Path);
            String s;
            String col = null;
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            Ram ram = null;
            Vga vga = null;
            Cpu cpu = null;
            Motherboard motherboard = null;
            Hard_disk hard_disk = null;
            BuildSequence buildSequence = null;
            while((s = in.readLine()) != null){
            	System.out.println(s);
            	if(s.equals("new")) {
            		ram = new Ram();
            		vga = new Vga();
            		cpu = new Cpu();
            		motherboard = new Motherboard();
            		hard_disk = new Hard_disk();
            		continue;
            	}
            	else if(s.equals("end")) {
            		buildSequence = new BuildSequence(ram, vga, cpu, motherboard, hard_disk);
            		list.add(buildSequence);
            		continue;
            	}
            	else if(s.startsWith("ram")){
                    col = "ram";
                    continue;
                }
                else if(s.startsWith("cpu")){
                    col = "cpu";
                    continue;
                }
                else if(s.startsWith("vga")){
                    col = "vga";
                    continue;
                }
                else if(s.startsWith("motherboard")){
                    col = "motherboard";
                    continue;
                }
                else if(s.startsWith("hard_disk")){
                    col = "hard_disk";
                    continue;
                }
                String arr[]= null;
                
                String ret = s;
                ret = ret.replace("'", "\"");
                ret = ret.replaceFirst(ret.substring(17, 43), ret.substring(17, 43).replaceAll("\"", "")); 
                ret = ret.replaceAll("ObjectId", "");
//                ret = ret.replaceAll("Details about", "");
//                ret = ret.replaceAll("  ", "");
//                ret = ret.replaceAll("xa0", "");
                ret = ret.replace(Character.toString('\\'), "");
                ret = ret.replace(Character.toString(ret.charAt(33)), "\"");
                ret = ret.replace(Character.toString(ret.charAt(8)), "\"");
                arr = ret.split("\"");
                if(col.equals("ram")){
                    ram.setId(arr[3]);
                    ram.setName(arr[7]);
                    ram.setPrice(arr[15]);
                    ram.setImage(arr[27]);
//                    ram.setUser_rating(arr[39]);
                }
                else if(col.equals("vga")){
                    vga.setId(arr[3]);
                    vga.setName(arr[7]);
                    vga.setPrice(arr[15]);
                    vga.setImage(arr[27]);
//                    vga.setUser_rating(arr[49]);
                }
                else if(col.equals("cpu")){
                    cpu.setId(arr[3]);
                    cpu.setName(arr[7]);
                    cpu.setPrice(arr[15]);
                    cpu.setImage(arr[27]);
//                    cpu.setUser_rating(arr[47]);
                }
                else if(col.equals("motherboard")){
                	motherboard.setId(arr[3]);
                	motherboard.setName(arr[7]);
                	motherboard.setPrice(arr[15]);
                	motherboard.setImage(arr[27]);
//                	motherboard.setUser_rating(arr[47]);
                }
                else if(col.equals("hard_disk")){
                	hard_disk.setId(arr[3]);
                	hard_disk.setName(arr[7]);
                	hard_disk.setPrice(arr[15]);
                	hard_disk.setImage(arr[27]);
//                	hard_disk.setUser_rating(arr[32]);
                } 
            	System.out.println(ret);
            } 
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

		TechRingResponse techRingResponse = new TechRingResponse();
//		List<BuildSequence> list = buildForPriceService.budget_plan(min, max);
		techRingResponse.setResponseCode("111"); 
		techRingResponse.setResponseObject(list);
		
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "max_min_budget")
	public TechRingResponse max_min_budget() {
		HashMap<String, Double> res = buildForPriceService.getMaxMinBudget();
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(res);
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "change/{pro}/{min}/{max}/{motherboard}/{cpu}/{ram}/{vga}/{hard_disk}")
	public TechRingResponse changePCPart(@PathVariable("pro") String pro, @PathVariable("min") String min, @PathVariable("max") String max, @PathVariable("motherboard") String motherboard_pro, @PathVariable("cpu") String cpu_pro, @PathVariable("ram") String ram_pro, @PathVariable("vga") String vga_pro, @PathVariable("hard_disk") String hard_disk_pro) {
		
//		String Path = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Reasearh_Scripts\\price_optimization\\build_for_price\\Build_sequence_change_product.py "+pro+" "+min+" "+max+" "+motherboard_pro+" "+cpu_pro+" "+ram_pro+" "+vga_pro+" "+hard_disk_pro;
		String Path = "python D:\\Tech-Ring-Team\\Reasearh_Scripts\\price_optimization\\build_for_price\\Build_sequence_change_product.py "+pro+" "+min+" "+max+" "+motherboard_pro+" "+cpu_pro+" "+ram_pro+" "+vga_pro+" "+hard_disk_pro;
		Ram ram = new Ram();
        Vga vga = new Vga();
        Cpu cpu = new Cpu();
        Motherboard motherboard = new Motherboard();
        Hard_disk hard_disk = new Hard_disk();
		try {
			Process p = Runtime.getRuntime().exec(Path);
            String s;
            String col = null;
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((s = in.readLine()) != null){
//            	System.out.println(s);
            	String arr[]= null;
            	String ret = s;
                ret = ret.replace("'", "\"");
                
                ret = ret.replaceFirst(ret.substring(17, 43), ret.substring(17, 43).replaceAll("\"", "")); 
                ret = ret.replaceAll("ObjectId", "");
//                ret = ret.replaceAll("Details about", "");
//                ret = ret.replaceAll("  ", "");
//                ret = ret.replaceAll("xa0", "");
                ret = ret.replace(Character.toString('\\'), "");
                ret = ret.replace(Character.toString(ret.charAt(33)), "\"");
                ret = ret.replace(Character.toString(ret.charAt(8)), "\"");
                arr = ret.split("\"");
                if(pro.equals("ram")){
                    ram.setId(arr[3]);
                    ram.setName(arr[7]);
                    ram.setPrice(arr[15]);
                    ram.setImage(arr[27]);
//                    ram.setUser_rating(arr[39]);
                }
                else if(pro.equals("vga")){
                    vga.setId(arr[3]);
                    vga.setName(arr[7]);
                    vga.setPrice(arr[15]);
                    vga.setImage(arr[27]);
//                    vga.setUser_rating(arr[49]);
                }
                else if(pro.equals("cpu")){
                    cpu.setId(arr[3]);
                    cpu.setName(arr[7]);
                    cpu.setPrice(arr[15]);
                    cpu.setImage(arr[27]);
//                    cpu.setUser_rating(arr[47]);
                }
                else if(pro.equals("motherboard")){
                	motherboard.setId(arr[3]);
                	motherboard.setName(arr[7]);
                	motherboard.setPrice(arr[15]);
                	motherboard.setImage(arr[27]);
//                	motherboard.setUser_rating(arr[47]);
                }
                else if(pro.equals("hard_disk")){
                	hard_disk.setId(arr[3]);
                	hard_disk.setName(arr[7]);
                	hard_disk.setPrice(arr[15]);
                	hard_disk.setImage(arr[27]);
//                	hard_disk.setUser_rating(arr[32]);
                } 
//                System.out.println(arr[3]);
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		TechRingResponse techRingResponse = new TechRingResponse();
		techRingResponse.setResponseCode("111");
		
		if(pro.equals("ram"))
			techRingResponse.setResponseObject(ram);
		else if(pro.equals("vga"))
			techRingResponse.setResponseObject(vga);
		else if(pro.equals("cpu"))
			techRingResponse.setResponseObject(cpu);
		else if(pro.equals("motherboard"))
			techRingResponse.setResponseObject(motherboard);
		else if(pro.equals("hard_disk"))
			techRingResponse.setResponseObject(hard_disk);
		return techRingResponse;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "budgetPlan_price/{ram_min}/{ram_max}/{vga_min}/{vga_max}/{cpu_min}/{cpu_max}/{motherboard_min}/{motherboard_max}/{hard_disk_min}/{hard_disk_max}")
	public TechRingResponse budget_plan_price(@PathVariable("ram_min") String ram_min, @PathVariable("ram_max") String ram_max, @PathVariable("vga_min") String vga_min, @PathVariable("vga_max") String vga_max, @PathVariable("cpu_min") String cpu_min, @PathVariable("cpu_max") String cpu_max, @PathVariable("motherboard_min") String motherboard_min, @PathVariable("motherboard_max") String motherboard_max, @PathVariable("hard_disk_min") String hard_disk_min, @PathVariable("hard_disk_max") String hard_disk_max) {
		System.out.println(ram_min+"   "+ram_max);
	
//		String Path = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Reasearh_Scripts\\price_optimization\\build_for_price\\Build_sequence_price_range.py "+ram_min+" "+ram_max+" "+vga_min+" "+vga_max+" "+cpu_min+" "+cpu_max+" "+motherboard_min+" "+motherboard_max+" "+hard_disk_min+" "+hard_disk_max;
		String Path = "python D:\\Tech-Ring-Team\\Reasearh_Scripts\\price_optimization\\build_for_price\\Build_sequence_price_range.py "+ram_min+" "+ram_max+" "+vga_min+" "+vga_max+" "+cpu_min+" "+cpu_max+" "+motherboard_min+" "+motherboard_max+" "+hard_disk_min+" "+hard_disk_max;
		List<BuildSequence> list = new ArrayList<BuildSequence>();
        try {
        	Process p = Runtime.getRuntime().exec(Path);
            String s;
            String col = null;
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            Ram ram = null;
            Vga vga = null;
            Cpu cpu = null;
            Motherboard motherboard = null;
            Hard_disk hard_disk = null;
            BuildSequence buildSequence = null;
            while((s = in.readLine()) != null){
            	System.out.println(s);
            	if(s.equals("new")) {
            		ram = new Ram();
            		vga = new Vga();
            		cpu = new Cpu();
            		motherboard = new Motherboard();
            		hard_disk = new Hard_disk();
            		continue;
            	}
            	else if(s.equals("end")) {
            		buildSequence = new BuildSequence(ram, vga, cpu, motherboard, hard_disk);
            		list.add(buildSequence);
            		continue;
            	}
            	else if(s.startsWith("ram")){
                    col = "ram";
                    continue;
                }
                else if(s.startsWith("cpu")){
                    col = "cpu";
                    continue;
                }
                else if(s.startsWith("vga")){
                    col = "vga";
                    continue;
                }
                else if(s.startsWith("motherboard")){
                    col = "motherboard";
                    continue;
                }
                else if(s.startsWith("hard_disk")){
                    col = "hard_disk";
                    continue;
                }
                String arr[]= null;
//                System.out.println(s);
                String ret = s;
                ret = ret.replace("'", "\"");
                ret = ret.replaceFirst(ret.substring(17, 43), ret.substring(17, 43).replaceAll("\"", "")); 
                ret = ret.replaceAll("ObjectId", "");
//                ret = ret.replaceAll("Details about", "");
//                ret = ret.replaceAll("  ", "");
//                ret = ret.replaceAll("xa0", "");
                ret = ret.replace(Character.toString('\\'), "");
                ret = ret.replace(Character.toString(ret.charAt(33)), "\"");
                ret = ret.replace(Character.toString(ret.charAt(8)), "\"");
                arr = ret.split("\"");
//                System.out.println(ret);
                if(col.equals("ram")){
                    ram.setId(arr[3]);
                    ram.setName(arr[7]);
                    ram.setPrice(arr[15]);
                    ram.setImage(arr[27]);
//                    ram.setUser_rating(arr[39]);
                }
                else if(col.equals("vga")){
                    vga.setId(arr[3]);
                    vga.setName(arr[7]);
                    vga.setPrice(arr[15]);
                    vga.setImage(arr[27]);
//                    vga.setUser_rating(arr[49]);
                }
                else if(col.equals("cpu")){
                    cpu.setId(arr[3]);
                    cpu.setName(arr[7]);
                    cpu.setPrice(arr[15]);
                    cpu.setImage(arr[27]);
//                    cpu.setUser_rating(arr[47]);
                }
                else if(col.equals("motherboard")){
                	motherboard.setId(arr[3]);
                	motherboard.setName(arr[7]);
                	motherboard.setPrice(arr[15]);
                	motherboard.setImage(arr[27]);
//                	motherboard.setUser_rating(arr[47]);
                }
                else if(col.equals("hard_disk")){
                	hard_disk.setId(arr[3]);
                	hard_disk.setName(arr[7]);
                	hard_disk.setPrice(arr[15]);
                	hard_disk.setImage(arr[27]);
//                	hard_disk.setUser_rating(arr[32]);
                } 
            } 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

		TechRingResponse techRingResponse = new TechRingResponse();
//		List<BuildSequence> list = buildForPriceService.budget_plan(min, max);
		techRingResponse.setResponseCode("111");
		techRingResponse.setResponseObject(list);
		
		return techRingResponse;
	} 
	
	@RequestMapping(method = RequestMethod.GET , value = "budgetPlan_price/test")
	public void test() {
		String Path = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Reasearh_Scripts\\price_optimization\\build_for_price\\test.py";
		try {
        	Process p = Runtime.getRuntime().exec(Path);
            String s;
            String col = null;
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((s = in.readLine()) != null){
            	String ret = s;
                ret = ret.replace("'", "\"");
                ret = ret.replaceFirst(ret.substring(17, 43), ret.substring(17, 43).replaceAll("\"", "")); 
                ret = ret.replaceAll("ObjectId", "");
                ret = ret.replace(Character.toString('\\'), "");
                ret = ret.replace(Character.toString(ret.charAt(33)), "\"");
                ret = ret.replace(Character.toString(ret.charAt(8)), "\"");
                String arr[]= null;
                arr = ret.split("\"");
                System.out.println(arr[32]);
            }
            
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
