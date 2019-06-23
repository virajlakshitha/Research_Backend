package com.tech.ring.service;

import java.util.HashMap;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;
import com.tech.ring.request.PCPartRequest;

public interface PCPartService {
	
	public HashMap<String, String> createNewRam(PCPartRequest pcpartRequest);
	public Ram getRamPartsByName(String name);
	public Ram getRamPartsById(String id);
	public Ram findRamVendorPrices(String part_name);
	
	public HashMap<String, String> createNewVga(PCPartRequest pcpartRequest);
	public Vga getVgaPartsByName(String name);
	public Vga getVgaPartsById(String id);
	public Vga findVgaVendorPrices(String part_name);
	
	public HashMap<String, String> createNewCpu(PCPartRequest pcpartRequest);
	public Cpu getCpuPartsByName(String name);
	public Cpu getCpuPartsById(String id);
	public Cpu findCpuVendorPrices(String part_name);
	
	public HashMap<String, String> createNewMotherboard(PCPartRequest pcpartRequest);
	public Motherboard getMotherboardPartsByName(String name);
	public Motherboard getMotherboardPartsById(String id);
	public Motherboard findMotherboardVendorPrices(String part_name);
	
	public HashMap<String, String> createNewHardDisk(PCPartRequest pcpartRequest);
	public Hard_disk getHardDiskPartsByName(String name);
	public Hard_disk getHardDiskPartsById(String id);
	public Hard_disk findHardDiskVendorPrices(String part_name);
	
}
