package com.tech.ring.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.ring.domain.Cpu;
import com.tech.ring.domain.Hard_disk;
import com.tech.ring.domain.Motherboard;
import com.tech.ring.domain.Ram;
import com.tech.ring.domain.Vga;
import com.tech.ring.enums.TechRingApplicationErrors;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.repository.PCPartDao;
import com.tech.ring.request.PCPartRequest;

@Service
public class PCPartServiceImpl implements PCPartService{
	
		
	@Autowired
	PCPartDao pcpartDao;

	@Override
	public HashMap<String, String> createNewRam(PCPartRequest pcpartRequest) {
		
		Ram pcpart = pcpartDao.findByRamPartByName(pcpartRequest.getName());
		
		if(pcpart == null) {
			Ram newpcpart = new Ram();
			
			newpcpart.setName(pcpartRequest.getName());
			newpcpart.setSize(pcpartRequest.getSize());
			newpcpart.setPrice(pcpartRequest.getPrice());
			
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
	public Ram getRamPartsByName(String name) {
		
		Ram pcpart = pcpartDao.findByRamPartByName(name);
		
		if(pcpart != null) {
			Ram newpcpart = new Ram();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Ram getRamPartsById(String id) {

		Ram pcpart = pcpartDao.findByRamPartById(id);
		
		if(pcpart != null) {
			Ram newpcpart = new Ram();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Ram findRamVendorPrices(String part_name) {
		Ram pcpart = pcpartDao.findByRamPartByName(part_name);
		
		if(pcpart != null) {
			Ram newpcpart = new Ram();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public HashMap<String, String> createNewVga(PCPartRequest pcpartRequest) {
		Vga pcpart = pcpartDao.findByVgaPartByName(pcpartRequest.getName());
		
		if(pcpart == null) {
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
	public Vga getVgaPartsByName(String name) {
		Vga pcpart = pcpartDao.findByVgaPartByName(name);
		
		if(pcpart != null) {
			Vga newpcpart = new Vga();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Vga getVgaPartsById(String id) {
		Vga pcpart = pcpartDao.findByVgaPartById(id);
		
		if(pcpart != null) {
			Vga newpcpart = new Vga();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Vga findVgaVendorPrices(String part_name) {
		Vga pcpart = pcpartDao.findByVgaPartByName(part_name);
		
		if(pcpart != null) {
			Vga newpcpart = new Vga();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public HashMap<String, String> createNewCpu(PCPartRequest pcpartRequest) {
		Cpu pcpart = pcpartDao.findByCpuPartByName(pcpartRequest.getName());
		
		if(pcpart == null) {
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
	public Cpu getCpuPartsByName(String name) {
		Cpu pcpart = pcpartDao.findByCpuPartByName(name);
		
		if(pcpart != null) {
			Cpu newpcpart = new Cpu();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Cpu getCpuPartsById(String id) {
		Cpu pcpart = pcpartDao.findByCpuPartById(id);
		
		if(pcpart != null) {
			Cpu newpcpart = new Cpu();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Cpu findCpuVendorPrices(String part_name) {
		Cpu pcpart = pcpartDao.findByCpuPartByName(part_name);
		
		if(pcpart != null) {
			Cpu newpcpart = new Cpu();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public HashMap<String, String> createNewMotherboard(PCPartRequest pcpartRequest) {
		Motherboard pcpart = pcpartDao.findByMotherboardPartByName(pcpartRequest.getName());
		
		if(pcpart == null) {
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
	public Motherboard getMotherboardPartsByName(String name) {
		Motherboard pcpart = pcpartDao.findByMotherboardPartByName(name);
		
		if(pcpart != null) {
			Motherboard newpcpart = new Motherboard();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Motherboard getMotherboardPartsById(String id) {
		Motherboard pcpart = pcpartDao.findByMotherboardPartById(id);
		
		if(pcpart != null) {
			Motherboard newpcpart = new Motherboard();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Motherboard findMotherboardVendorPrices(String part_name) {
		Motherboard pcpart = pcpartDao.findByMotherboardPartByName(part_name);
		
		if(pcpart != null) {
			Motherboard newpcpart = new Motherboard();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public HashMap<String, String> createNewHardDisk(PCPartRequest pcpartRequest) {
		Hard_disk pcpart = pcpartDao.findByHard_diskPartByName(pcpartRequest.getName());
		
		if(pcpart == null) {
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
	public Hard_disk getHardDiskPartsByName(String name) {
		Hard_disk pcpart = pcpartDao.findByHard_diskPartByName(name);
		
		if(pcpart != null) {
			Hard_disk newpcpart = new Hard_disk();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Hard_disk getHardDiskPartsById(String id) {
		Hard_disk pcpart = pcpartDao.findByHard_diskPartById(id);
		
		if(pcpart != null) {
			Hard_disk newpcpart = new Hard_disk();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public Hard_disk findHardDiskVendorPrices(String part_name) {
		Hard_disk pcpart = pcpartDao.findByHard_diskPartByName(part_name);
		
		if(pcpart != null) {
			Hard_disk newpcpart = new Hard_disk();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			return newpcpart;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}


}
