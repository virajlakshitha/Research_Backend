package com.tech.ring.request;

public class CpuRequest {
	
private String brand;
	
	private String model;
	
	private String cache;
	
	private String baseSpeed;
	
	private String bootSpeed;
	
	private String cores;
	
	private String rating;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}

	public String getBaseSpeed() {
		return baseSpeed;
	}

	public void setBaseSpeed(String baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public String getBootSpeed() {
		return bootSpeed;
	}

	public void setBootSpeed(String bootSpeed) {
		this.bootSpeed = bootSpeed;
	}

	public String getCores() {
		return cores;
	}

	public void setCores(String cores) {
		this.cores = cores;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}
