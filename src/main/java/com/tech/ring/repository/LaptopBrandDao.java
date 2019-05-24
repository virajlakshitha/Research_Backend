package com.tech.ring.repository;

import java.util.List;

import com.tech.ring.domain.LaptopBrands;

public interface LaptopBrandDao{
	
	public LaptopBrands findByLapBrandName(String lapBrandName);
	public LaptopBrands saveLaptopBrand(LaptopBrands laptopBrands);
	public List<LaptopBrands> findAllBrands();
}
