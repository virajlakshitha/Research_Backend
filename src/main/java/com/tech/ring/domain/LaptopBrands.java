package com.tech.ring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class LaptopBrands {
	
	@Id
	private String id;
	
	private String lapBrandName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLapBrandName() {
		return lapBrandName;
	}

	public void setLapBrandName(String lapBrandName) {
		this.lapBrandName = lapBrandName;
	}
}
