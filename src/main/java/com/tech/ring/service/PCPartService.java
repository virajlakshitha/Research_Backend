package com.tech.ring.service;

import java.util.HashMap;
import java.util.List;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.User;
import com.tech.ring.domain.Vga;
import com.tech.ring.request.PCPartRequest;

public interface PCPartService {
	
	public List<Ram> getRamParts();
	
	public HashMap<String, String> createNewRam(PCPartRequest pcpartRequest);
	public List<Ram> getRamPartsByName(String name);
	public Ram getRamPartsById(String id);
	public List<Ram> findRamVendorPrices(String part_name);
	
	public HashMap<String, String> createNewVga(PCPartRequest pcpartRequest);
	public List<Vga> getVgaPartsByName(String name);
	public Vga getVgaPartsById(String id);
	public List<Vga> findVgaVendorPrices(String part_name);
	
	public HashMap<String, String> createNewCpu(PCPartRequest pcpartRequest);
	public List<Cpu> getCpuPartsByName(String name);
	public Cpu getCpuPartsById(String id);
	public List<Cpu> findCpuVendorPrices(String part_name);
	
	public HashMap<String, String> createNewMotherboard(PCPartRequest pcpartRequest);
	public List<Motherboard> getMotherboardPartsByName(String name);
	public Motherboard getMotherboardPartsById(String id);
	public List<Motherboard> findMotherboardVendorPrices(String part_name);
	
	public HashMap<String, String> createNewHardDisk(PCPartRequest pcpartRequest);
	public List<Hard_disk> getHardDiskPartsByName(String name);
	public Hard_disk getHardDiskPartsById(String id);
	public List<Hard_disk> findHardDiskVendorPrices(String part_name);
	
	public List<User> getVendorsForProduct(String category, String pro_name);
	
	public void pushNotification(String user_id, String product, String price);
}
