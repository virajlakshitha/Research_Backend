package com.tech.ring.repository;

import com.tech.ring.domain.PCPart;

public interface PCPartDao {

	public PCPart findByPartName(String partName);
	public PCPart findByPartByName(String partName, String category);
	public PCPart findByPartById(String id, String category);
	public PCPart savePCPart(PCPart pcpart);
}
