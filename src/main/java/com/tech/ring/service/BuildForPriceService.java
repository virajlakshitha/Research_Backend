package com.tech.ring.service;

import java.util.HashMap;
import java.util.List;

import com.tech.ring.domain.BuildSequence;
import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;

public interface BuildForPriceService {
	
	public List<Ram> getAll();

	public List<Ram> getRamUnderBudget(Double min,Double max);
	public List<Vga> getVgaUnderBudget(Double min,Double max);
	public List<Cpu> getCpuUnderBudget(Double min,Double max);
	public List<Motherboard> getMotherboardUnderBudget(Double min,Double max);
	public List<Hard_disk> getHardDiskUnderBudget(Double min,Double max);
	
	public List<BuildSequence> budget_plan(Double min, Double max);
	public List<BuildSequence> budget_plan_price(String category, Double min, Double max);
	
	public HashMap<String, Double> getMaxMinBudget();
}
