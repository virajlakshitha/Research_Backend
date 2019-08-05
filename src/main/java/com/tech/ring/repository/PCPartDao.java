package com.tech.ring.repository;

import java.util.List;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.User;
import com.tech.ring.domain.Vga;

public interface PCPartDao {
	
	public List<Ram> findBygetRamParts();
	
	public List<Ram> findByRamPartByName(String partName);
	public Ram findByRamPartById(String id);
	public List<Ram> findRamVendorPrices(String part_name);
	public Ram saveRam(Ram pcpart);
	
	public List<Vga> findByVgaPartByName(String partName);
	public Vga findByVgaPartById(String id);
	public List<Vga> findVgaVendorPrices(String part_name);
	public Vga saveVga(Vga pcpart);
	
	public List<Cpu> findByCpuPartByName(String partName);
	public Cpu findByCpuPartById(String id);
	public List<Cpu> findCpuVendorPrices(String part_name);
	public Cpu saveCpu(Cpu pcpart);
	
	public List<Motherboard> findByMotherboardPartByName(String partName);
	public Motherboard findByMotherboardPartById(String id);
	public List<Motherboard> findMotherboardVendorPrices(String part_name);
	public Motherboard saveMotherboard(Motherboard pcpart);
	
	public List<Hard_disk> findByHard_diskPartByName(String partName);
	public Hard_disk findByHard_diskPartById(String id);
	public List<Hard_disk> findHard_diskVendorPrices(String part_name);
	public Hard_disk saveHard_disk(Hard_disk pcpart);
	
	public List<User> getVendorsForProduct(String category, String pro_name);
	
	public void pushNotification(String user_id, String product, String price);
}
