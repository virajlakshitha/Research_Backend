package com.tech.ring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "laptops")
public class Laptop {
	
	@Id
	private String id;
	
	private String lapName;
	
	private String lapBrand;
	
	private String cpuModel;
	
	private String cpuCoresSize;
	
	private String cpuCachSize;
	
	private String cpuBoostSpeed;
	
	private String ramType;
	
	private String ramSize;
	
	private String storageType;
	
	private String storageSize;
	
	private String batteryType;
	
	private String batteryCapacity;
	
	private String gpuMemorySize;
	
	private String gpuBooStSpeed;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLapName() {
		return lapName;
	}

	public void setLapName(String lapName) {
		this.lapName = lapName;
	}

	public String getLapBrand() {
		return lapBrand;
	}

	public void setLapBrand(String lapBrand) {
		this.lapBrand = lapBrand;
	}

	public String getCpuModel() {
		return cpuModel;
	}

	public void setCpuModel(String cpuModel) {
		this.cpuModel = cpuModel;
	}

	public String getCpuCoresSize() {
		return cpuCoresSize;
	}

	public void setCpuCoresSize(String cpuCoresSize) {
		this.cpuCoresSize = cpuCoresSize;
	}

	public String getCpuCachSize() {
		return cpuCachSize;
	}

	public void setCpuCachSize(String cpuCachSize) {
		this.cpuCachSize = cpuCachSize;
	}

	public String getCpuBoostSpeed() {
		return cpuBoostSpeed;
	}

	public void setCpuBoostSpeed(String cpuBoostSpeed) {
		this.cpuBoostSpeed = cpuBoostSpeed;
	}

	public String getRamType() {
		return ramType;
	}

	public void setRamType(String ramType) {
		this.ramType = ramType;
	}

	public String getRamSize() {
		return ramSize;
	}

	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(String storageSize) {
		this.storageSize = storageSize;
	}

	public String getBatteryType() {
		return batteryType;
	}

	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getGpuMemorySize() {
		return gpuMemorySize;
	}

	public void setGpuMemorySize(String gpuMemorySize) {
		this.gpuMemorySize = gpuMemorySize;
	}

	public String getGpuBooStSpeed() {
		return gpuBooStSpeed;
	}

	public void setGpuBooStSpeed(String gpuBooStSpeed) {
		this.gpuBooStSpeed = gpuBooStSpeed;
	}	
}
