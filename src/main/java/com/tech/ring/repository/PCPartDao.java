package com.tech.ring.repository;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;

public interface PCPartDao {
	
	public Ram findByRamPartByName(String partName);
	public Ram findByRamPartById(String id);
	public Ram findRamVendorPrices(String part_name);
	public Ram saveRam(Ram pcpart);
	
	public Vga findByVgaPartByName(String partName);
	public Vga findByVgaPartById(String id);
	public Vga findVgaVendorPrices(String part_name);
	public Vga saveVga(Vga pcpart);
	
	public Cpu findByCpuPartByName(String partName);
	public Cpu findByCpuPartById(String id);
	public Cpu findCpuVendorPrices(String part_name);
	public Cpu saveCpu(Cpu pcpart);
	
	public Motherboard findByMotherboardPartByName(String partName);
	public Motherboard findByMotherboardPartById(String id);
	public Motherboard findMotherboardVendorPrices(String part_name);
	public Motherboard saveMotherboard(Motherboard pcpart);
	
	public Hard_disk findByHard_diskPartByName(String partName);
	public Hard_disk findByHard_diskPartById(String id);
	public Hard_disk findHard_diskVendorPrices(String part_name);
	public Hard_disk saveHard_disk(Hard_disk pcpart);
}
