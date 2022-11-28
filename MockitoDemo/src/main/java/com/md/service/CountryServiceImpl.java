package com.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.entities.Country;
import com.md.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryRepository countryRepo;

	@Override
	public List<Country> getAllCountries() {
		List<Country> countryList = countryRepo.findAll();
		return countryList;
	}

	@Override
	public Country getCountryByName(String countryName) {
		Country country = countryRepo.findByCountryName(countryName);
		return country;
	}

	@Override
	public Country addCountry(Country country) {
		Country myCountry = countryRepo.save(country);
		return myCountry;
	}

	@Override
	public Country updateCountry(Country myCountry) {
//		Country country = getCountryByName(myCountry.getCountryName());
//		if (country != null) {                
//			country.setCountryName(myCountry.getCountryName());
//			country.setCapitalName(myCountry.getCapitalName());
//			countryRepo.save(country);
//		}
		Country savedCountry = countryRepo.save(myCountry);
		return savedCountry;
	}

	@Override
	public Country getCountryById(int countryId) {
		
		List<Country> countryList = countryRepo.findAll();
		Country ctry=null;
		for(Country c:countryList) {
			if(c.getCountryId()==countryId) {
				ctry=c;
			}
		}
		return ctry;
	}

	@Override
	public void deleteCountry(Country country) {
		countryRepo.delete(country);
	}                                                                                      

}
