package com.tech.ring.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.tech.ring.service.SmtpMail;

@RestController
public class scrape {
	
	@Autowired
	private SmtpMail smtpMail;
	
	@Scheduled(initialDelay = 1000, fixedRate = 86400000)
	public void ram_scrape() {
	    try {
	    	System.out.println("Schedule running");
	    	String Path = "python C:\\Users\\viraj\\Desktop\\Research_BackEnd\\Python\\Search_products_v1.py";
	    	Process p = Runtime.getRuntime().exec(Path);
//	    	notifyPrice("virajlkgunathilaka96@gmail.com", "RAM", "14500.00");
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public void notifyPrice(String to, String product, String price) {
		
		try {
			smtpMail.send(to, "Price of "+product+" is down to "+price);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
