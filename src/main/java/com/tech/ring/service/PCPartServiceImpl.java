package com.tech.ring.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.ring.domain.Laptop;
import com.tech.ring.domain.PCPart;
import com.tech.ring.enums.TechRingApplicationErrors;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.repository.PCPartDao;
import com.tech.ring.request.PCPartRequest;

@Service
public class PCPartServiceImpl implements PCPartService {
	
	@Autowired
	PCPartDao pcpartDao;

	@Override
	public HashMap<String, String> createNewPCPart(PCPartRequest pcpartRequest) {
		
		PCPart pcpart = pcpartDao.findByPartName(pcpartRequest.getName());
		
		if(pcpart == null) {
			PCPart newpcpart = new PCPart();
			
			newpcpart.setId(pcpartRequest.getId());
			newpcpart.setName(pcpartRequest.getName());
			newpcpart.setBrand(pcpartRequest.getBrand());
			newpcpart.setCategory(pcpartRequest.getCategory());
			newpcpart.setDescription(pcpartRequest.getDescription());
			newpcpart.setSize(pcpartRequest.getSize());
			newpcpart.setPrice(pcpartRequest.getPrice());
			
			PCPart pcpartResult = pcpartDao.savePCPart(newpcpart);
			
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
	public PCPart getPCPart(String name) {
		
		PCPart pcpart = pcpartDao.findByPartName(name);
			
			if(pcpart != null) {
				PCPart newpcpart = new PCPart();
				
				newpcpart.setId(pcpart.getId());
				newpcpart.setName(pcpart.getName());
				newpcpart.setBrand(pcpart.getBrand());
				newpcpart.setCategory(pcpart.getCategory());
				newpcpart.setDescription(pcpart.getDescription());
				newpcpart.setSize(pcpart.getSize());
				newpcpart.setPrice(pcpart.getPrice());
				
				PCPart pcpartResult = pcpartDao.savePCPart(newpcpart);
				return pcpartResult;
				
			}
			else {
				throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
			}
	}

	@Override
	public PCPart getPCPartsByName(String name, String category) {
		
		PCPart pcpart = pcpartDao.findByPartByName(name, category);
		pcpart.setId("111");
		pcpart.setBrand("Kingston");
		pcpart.setCategory("RAM");
		pcpart.setDescription("Brand New one");
		pcpart.setName("Kinston 4GB RAM");
		pcpart.setPrice(45000.00);
		pcpart.setSize("4GB");
		
		if(pcpart != null) {
			PCPart newpcpart = new PCPart();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setBrand(pcpart.getBrand());
			newpcpart.setCategory(pcpart.getCategory());
			newpcpart.setDescription(pcpart.getDescription());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			
			PCPart pcpartResult = pcpartDao.savePCPart(newpcpart);
			return pcpartResult;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}

	@Override
	public PCPart getPCPartsById(String id, String category) {

		PCPart pcpart = pcpartDao.findByPartById(id, category);
		
		if(pcpart != null) {
			PCPart newpcpart = new PCPart();
			
			newpcpart.setId(pcpart.getId());
			newpcpart.setName(pcpart.getName());
			newpcpart.setBrand(pcpart.getBrand());
			newpcpart.setCategory(pcpart.getCategory());
			newpcpart.setDescription(pcpart.getDescription());
			newpcpart.setSize(pcpart.getSize());
			newpcpart.setPrice(pcpart.getPrice());
			
			PCPart pcpartResult = pcpartDao.savePCPart(newpcpart);
			return pcpartResult;
			
		}
		else {
			throw new TechRingException(TechRingApplicationErrors.PCPART_NOT_FOUND);
		}
	}
}
