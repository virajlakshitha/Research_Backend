package com.tech.ring.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.User;
import com.tech.ring.domain.Vga;
import com.tech.ring.domain.Notification;
import com.tech.ring.enums.TechRingApplicationErrors;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.repository.PCPartDao;
import com.tech.ring.request.NotificationRequest;
import com.tech.ring.request.PCPartRequest;

@Service
public class PCPartServiceImpl implements PCPartService{
	
		
	@Autowired
	PCPartDao pcpartDao;

	@Override
	public HashMap<String, String> createNewRam(PCPartRequest pcpartRequest) {
		List<Ram> pcpart = pcpartDao.findByRamPartByName(pcpartRequest.getName());
		System.out.println(pcpart);
		if(pcpart == null || pcpart.isEmpty()) {
			Ram newpcpart = new Ram();
			
			newpcpart.setName(pcpartRequest.getName());
//			newpcpart.setSize(pcpartRequest.getSize());
//			newpcpart.setPrice(pcpartRequest.getPrice());
			
			Ram pcpartResult = pcpartDao.saveRam(newpcpart);
			
			if(pcpartResult != null) {
				
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("message", "PC Part created");
				return hm;
			}
			else {
				throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_CREATED);
			}
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_ALLREADY_EXISTS);
		}
		
	}

	@Override
	public List<Ram> getRamPartsByName(String name) {
		
		List<Ram> pcpart = pcpartDao.findByRamPartByName(name);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			return pcpart;
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Ram getRamPartsById(String id) {

		Ram pcpart = pcpartDao.findByRamPartById(id);
		
		if(pcpart != null) {
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Ram> findRamVendorPrices(String part_name, String company) {
		List<Ram> pcpart = pcpartDao.findRamVendorPrices(part_name, company);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			return pcpart;
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public HashMap<String, String> createNewVga(PCPartRequest pcpartRequest) {
		List<Vga> pcpart = pcpartDao.findByVgaPartByName(pcpartRequest.getName());
		
		if(pcpart == null || pcpart.isEmpty()) {
			Vga newpcpart = new Vga();
			
			newpcpart.setName(pcpartRequest.getName());
			newpcpart.setSize(pcpartRequest.getSize());
			newpcpart.setPrice(pcpartRequest.getPrice());
			
			Vga pcpartResult = pcpartDao.saveVga(newpcpart);
			
			if(pcpartResult != null) {
				
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("message", "PC Part created");
				return hm;
			}
			else {
				throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_CREATED);
			}
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_ALLREADY_EXISTS);
		}
	}

	@Override
	public List<Vga> getVgaPartsByName(String name) {
		List<Vga> pcpart = pcpartDao.findByVgaPartByName(name);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Vga getVgaPartsById(String id) {
		Vga pcpart = pcpartDao.findByVgaPartById(id);
		
		if(pcpart != null) {
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Vga> findVgaVendorPrices(String part_name, String company) {
		List<Vga> pcpart = pcpartDao.findVgaVendorPrices(part_name, company);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public HashMap<String, String> createNewCpu(PCPartRequest pcpartRequest) {
		List<Cpu> pcpart = pcpartDao.findByCpuPartByName(pcpartRequest.getName());
		
		if(pcpart == null || pcpart.isEmpty()) {
			Cpu newpcpart = new Cpu();
			
			newpcpart.setName(pcpartRequest.getName());
			newpcpart.setSize(pcpartRequest.getSize());
			newpcpart.setPrice(pcpartRequest.getPrice());
			
			Cpu pcpartResult = pcpartDao.saveCpu(newpcpart);
			
			if(pcpartResult != null) {
				
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("message", "PC Part created");
				return hm;
			}
			else {
				throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_CREATED);
			}
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_ALLREADY_EXISTS);
		}
	}

	@Override
	public List<Cpu> getCpuPartsByName(String name) {
		List<Cpu> pcpart = pcpartDao.findByCpuPartByName(name);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Cpu getCpuPartsById(String id) {
		Cpu pcpart = pcpartDao.findByCpuPartById(id);
		
		if(pcpart != null) {
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Cpu> findCpuVendorPrices(String part_name, String company) {
		List<Cpu> pcpart = pcpartDao.findCpuVendorPrices(part_name, company);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public HashMap<String, String> createNewMotherboard(PCPartRequest pcpartRequest) {
		List<Motherboard> pcpart = pcpartDao.findByMotherboardPartByName(pcpartRequest.getName());
		
		if(pcpart == null || pcpart.isEmpty()) {
			Motherboard newpcpart = new Motherboard();
			
			newpcpart.setName(pcpartRequest.getName());
			newpcpart.setSize(pcpartRequest.getSize());
			newpcpart.setPrice(pcpartRequest.getPrice());
			
			Motherboard pcpartResult = pcpartDao.saveMotherboard(newpcpart);
			
			if(pcpartResult != null) {
				
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("message", "PC Part created");
				return hm;
			}
			else {
				throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_CREATED);
			}
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_ALLREADY_EXISTS);
		}
	}

	@Override
	public List<Motherboard> getMotherboardPartsByName(String name) {
		List<Motherboard> pcpart = pcpartDao.findByMotherboardPartByName(name);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Motherboard getMotherboardPartsById(String id) {
		Motherboard pcpart = pcpartDao.findByMotherboardPartById(id);
		
		if(pcpart != null) {
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Motherboard> findMotherboardVendorPrices(String part_name, String company) {
		List<Motherboard> pcpart = pcpartDao.findMotherboardVendorPrices(part_name, company);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public HashMap<String, String> createNewHardDisk(PCPartRequest pcpartRequest) {
		List<Hard_disk> pcpart = pcpartDao.findByHard_diskPartByName(pcpartRequest.getName());
		
		if(pcpart == null || pcpart.isEmpty()) {
			Hard_disk newpcpart = new Hard_disk();
			
			newpcpart.setName(pcpartRequest.getName());
			newpcpart.setSize(pcpartRequest.getSize());
			newpcpart.setPrice(pcpartRequest.getPrice());
			
			Hard_disk pcpartResult = pcpartDao.saveHard_disk(newpcpart);
			
			if(pcpartResult != null) {
				
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("message", "PC Part created");
				return hm;
			}
			else {
				throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_CREATED);
			}
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_ALLREADY_EXISTS);
		}
	}

	@Override
	public List<Hard_disk> getHardDiskPartsByName(String name) {
		List<Hard_disk> pcpart = pcpartDao.findByHard_diskPartByName(name);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Hard_disk getHardDiskPartsById(String id) {
		Hard_disk pcpart = pcpartDao.findByHard_diskPartById(id);
		
		if(pcpart != null) {
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Hard_disk> findHardDiskVendorPrices(String part_name, String company) {
		List<Hard_disk> pcpart = pcpartDao.findHard_diskVendorPrices(part_name, company);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Ram> getRamParts() {
		
		List<Ram> pcpart1 = pcpartDao.findBygetRamParts();
		
		if(pcpart1 != null && !pcpart1.isEmpty()) {
			return pcpart1;
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.CAN_NOT_FIND_MATCHING_RESULT);	
		}
	}

	@Override
	public List<User> getVendorsForProduct(String category, String pro_name) {
		
		List<User> users = pcpartDao.getVendorsForProduct(category, pro_name);
		
		if(users != null && users.isEmpty() ) {
			return users;
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.CAN_NOT_FIND_MATCHING_RESULT);	
		}
	}

	@Override
	public HashMap<String, String> pushNotification(NotificationRequest notificationRequest) {
		Notification res = pcpartDao.checkNotification(notificationRequest.getId(), notificationRequest.getProduct());
		
		if(res == null) {
			Notification newNotify = new Notification();
			
			newNotify.setEmail(res.getEmail());
			newNotify.setProduct(res.getProduct());
			
			Notification notifyResult = pcpartDao.pushNotification(newNotify);
			
			if(notifyResult != null) {
				
				HashMap<String, String> hm = new HashMap<>();
				
				hm.put("message", "Done");
				return hm;
			}
			else {
				throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_CREATED);
			}
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_ALLREADY_EXISTS);
		}
		
	}

	@Override
	public List<Ram> getSortedRamPartsByName(String name, int option) {
		List<Ram> pcpart = pcpartDao.findBySortedRamPartByName(name, option);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			return pcpart;
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Vga> getSortedVgaPartsByName(String name, int option) {
		List<Vga> pcpart = pcpartDao.findBySortedVgaPartByName(name, option);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Cpu> getSortedCpuPartsByName(String name, int option) {
		List<Cpu> pcpart = pcpartDao.findBySortedCpuPartByName(name, option);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Motherboard> getSortedMotherboardPartsByName(String name, int option) {
		List<Motherboard> pcpart = pcpartDao.findBySortedMotherboardPartByName(name, option);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public List<Hard_disk> getSortedHardDiskPartsByName(String name, int option) {
		List<Hard_disk> pcpart = pcpartDao.findBySortedHard_diskPartByName(name, option);
		
		if(pcpart != null && !pcpart.isEmpty()) {
			
			return pcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}


}
