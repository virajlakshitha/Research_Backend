package com.tech.ring.service;

import com.tech.ring.domain.Country;
import com.tech.ring.request.CountryRequest;

public interface CountryService {
	
	public Country createCountry(CountryRequest countryRequest);
	public Country countryFindById(String id);
}
