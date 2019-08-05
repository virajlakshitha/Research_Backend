package com.tech.ring.repository;

import java.util.List;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Game;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;

public interface BuildForPriceDao {
	
	public List<Ram> findAll();

	public Ram findRam(String min, String max);
	public Vga findVga(String min, String max);
	public Cpu findCpu(String min, String max);
	public Motherboard findMotherboard(String min, String max);
	public Hard_disk findHard_disk(String min, String max);
}
