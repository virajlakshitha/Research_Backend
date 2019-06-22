package com.tech.ring.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScrapingSchedule {

	@Scheduled(cron = "*/10 * * * * * ")
	public void cronejob() {
		System.out.println("hello");
		
		//Run python script here
		
	}
}
