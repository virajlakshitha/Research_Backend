package com.tech.ring.support;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class scrape {
	
	@Scheduled(initialDelay = 1000, fixedRate = 86400000)
	public void ram_scrape() {
	    try {
	    	System.out.println("Schedule running");
	    	//ram
	    	String Path = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Python\\Search_products_v1.py";
	    	Process p = Runtime.getRuntime().exec(Path);
	    	//vga
//	    	String Path_vga = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Python\\Search_products_v1.py";
//	    	Process p_vga = Runtime.getRuntime().exec(Path_vga);
	    	//cpu
//	    	String Path_cpu = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Python\\Search_products_v1.py";
//	    	Process p_cpu = Runtime.getRuntime().exec(Path_cpu);
	    	//motherboard
//	    	String Path_motherboard = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Python\\Search_products_v1.py";
//	    	Process p_motherboard = Runtime.getRuntime().exec(Path_motherboard);
	    	//hard_disk
//	    	String Path_hard = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Python\\Search_products_v1.py";
//	    	Process p_hard = Runtime.getRuntime().exec(Path_hard);
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	}

}
