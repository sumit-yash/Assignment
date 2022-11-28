package com.md.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.md.entities.Country;

public interface CountryService {

	public List<Country> getAllCountries();
	public Country getCountryById(int countryId);
	public Country getCountryByName(String countryName);
	public Country  addCountry(Country country);
	public Country  updateCountry(Country country);
	public void deleteCountry(Country country);

}
