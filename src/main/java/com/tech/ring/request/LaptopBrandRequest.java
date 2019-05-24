package com.tech.ring.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LaptopBrandRequest {
	
	private String lapBrandName;

	public String getLapBrandName() {
		return lapBrandName;
	}

	public void setLapBrandName(String lapBrandName) {
		this.lapBrandName = lapBrandName;
	}
}
