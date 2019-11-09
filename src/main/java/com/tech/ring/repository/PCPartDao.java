package com.tech.ring.repository;

import java.util.List;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.User;
import com.tech.ring.domain.Vga;
import com.tech.ring.domain.Notification;

public interface PCPartDao {
	
	public List<Ram> findBygetRamParts();
	
	public List<Ram> findByRamPartByName(String partName);
	public List<Ram> findBySortedRamPartByName(String partName, int option);
	public Ram findByRamPartById(String id);
	public List<Ram> findRamVendorPrices(String part_name, String company);
	public Ram saveRam(Ram pcpart);
	
	public List<Vga> findByVgaPartByName(String partName);
	public List<Vga> findBySortedVgaPartByName(String partName, int option);
	public Vga findByVgaPartById(String id);
	public List<Vga> findVgaVendorPrices(String part_name, String company);
	public Vga saveVga(Vga pcpart);
	
	public List<Cpu> findByCpuPartByName(String partName);
	public List<Cpu> findBySortedCpuPartByName(String partName, int option);
	public Cpu findByCpuPartById(String id);
	public List<Cpu> findCpuVendorPrices(String part_name, String company);
	public Cpu saveCpu(Cpu pcpart);
	
	public List<Motherboard> findByMotherboardPartByName(String partName);
	public List<Motherboard> findBySortedMotherboardPartByName(String partName, int option);
	public Motherboard findByMotherboardPartById(String id);
	public List<Motherboard> findMotherboardVendorPrices(String part_name, String company);
	public Motherboard saveMotherboard(Motherboard pcpart);
	
	public List<Hard_disk> findByHard_diskPartByName(String partName);
	public List<Hard_disk> findBySortedHard_diskPartByName(String partName, int option);
	public Hard_disk findByHard_diskPartById(String id);
	public List<Hard_disk> findHard_diskVendorPrices(String part_name, String company);
	public Hard_disk saveHard_disk(Hard_disk pcpart);
	
	public List<User> getVendorsForProduct(String category, String pro_name);
	
	public Notification checkNotification(String user_id, String product);
	public Notification pushNotification(Notification notification);
}
