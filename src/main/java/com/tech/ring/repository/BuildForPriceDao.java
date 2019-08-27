package com.tech.ring.repository;

import java.util.HashMap;
import java.util.List;

import com.tech.ring.domain.BuildSequence;
import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Game;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;

public interface BuildForPriceDao {
	
	public List<Ram> findAll();

	public List<Ram> findRam(Double min, Double max);
	public List<Vga> findVga(Double min, Double max);
	public List<Cpu> findCpu(Double min, Double max);
	public List<Motherboard> findMotherboard(Double min, Double max);
	public List<Hard_disk> findHard_disk(Double min, Double max);
	
	public List<BuildSequence> budget_plan(Double min, Double max);
	public List<BuildSequence> budget_plan_price(String category, Double min, Double max);
	
	public HashMap<String, Double> getMaxMinBudget();
}
