package com.tech.ring.repository;

import java.util.List;

import com.tech.ring.domain.Laptop;

public interface LaptopDao{
	
	public Laptop findByLapName(String lapName);
	public Laptop saveLaptop(Laptop laptop);
	public List<Laptop> findLaptop(String key);
}
