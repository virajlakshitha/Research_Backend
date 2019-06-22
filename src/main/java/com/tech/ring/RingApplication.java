package com.tech.ring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@ComponentScan({"com.tech.ring.request"})
public class RingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RingApplication.class, args);
	}

}
