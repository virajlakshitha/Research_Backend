package com.tech.ring.service;

import java.util.List;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;

public interface BuildForPriceService {
	
	public List<Ram> getAll();

	public Ram getRamUnderBudget(String min,String max);
	public Vga getVgaUnderBudget(String min,String max);
	public Cpu getCpuUnderBudget(String min,String max);
	public Motherboard getMotherboardUnderBudget(String min,String max);
	public Hard_disk getHardDiskUnderBudget(String min,String max);
}
