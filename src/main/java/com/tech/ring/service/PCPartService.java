package com.tech.ring.service;

import java.util.HashMap;

import com.tech.ring.domain.PCPart;
import com.tech.ring.request.PCPartRequest;

public interface PCPartService {
	
	public HashMap<String, String> createNewPCPart(PCPartRequest pcpartRequest);
	
	public PCPart getPCPart(String name);
	
	public PCPart getPCPartsByName(String name, String category);
	
	public PCPart getPCPartsById(String id, String category);
}
