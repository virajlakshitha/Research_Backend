package com.tech.ring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.ring.domain.Country;
import com.tech.ring.enums.TechRingApplicationErrors;
import com.tech.ring.exception.TechRingException;
import com.tech.ring.repository.CountryDao;
import com.tech.ring.request.CountryRequest;



@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryDao countryDao;
	
	@Override
	public Country createCountry(CountryRequest countryRequest) {
		
		Country isExist = countryDao.findByName(countryRequest.getCountryName());
		if(isExist == null) {
			Country country = new Country();
			country.setName(countryRequest.getCountryName());
			countryDao.save(country);
			return country;
		}else {
			throw new TechRingException(TechRingApplicationErrors.USER_NAME_ALREADY_EXISTS);
		}
		
	}
	
	/*
	 * Optional is a container type for a value which may be absent.  
	 * It introduced with java 8
	 * 
	 */
	@Override
	public Country countryFindById(String id) {
		
		Optional<Country> country = countryDao.findById(id);
		
		if(country.isPresent()) {
			Country country2 = country.get();
			return country2;
		}else {
			throw new TechRingException(TechRingApplicationErrors.USER_NAME_ALREADY_EXISTS);
		}
	}

}
