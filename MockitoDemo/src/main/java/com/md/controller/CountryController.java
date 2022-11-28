package com.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.md.entities.Country;
import com.md.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;

	@GetMapping("/allCountries")
	public ResponseEntity<List<Country>> allCountries() {
		List<Country> allCountries;
		try {
			allCountries = countryService.getAllCountries();
			return new ResponseEntity<List<Country>>(allCountries, HttpStatus.FOUND);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/country/{countryName}")
	public ResponseEntity<Country> countryByName(@RequestParam("countryName") String countryName) {

		try {
			Country country = countryService.getCountryByName(countryName);
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/country")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		try {
			Country addCountry = countryService.addCountry(country);
			return new ResponseEntity<Country>(addCountry, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/country/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable("id") int countryId, @RequestBody Country country) {

		try {
			Country existingCountry = countryService.getCountryByName(country.getCountryName());
			if (existingCountry != null) {
				existingCountry.setCapitalName(country.getCapitalName());
			}
			Country updateCountry = countryService.updateCountry(existingCountry);
			return new ResponseEntity<Country>(updateCountry, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/country/{id}")
	public ResponseEntity<Country> countryById(@PathVariable("id") int countryId) {
		try {
			Country getCountry = countryService.getCountryById(countryId);
			return new ResponseEntity<Country>(getCountry, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Country>( HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/country/{id}")
	public ResponseEntity<Country> deleteCountry(@PathVariable("id") int countryId) {
		try {
			Country country = countryService.getCountryById(countryId);
			countryService.deleteCountry(country);
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Country>( HttpStatus.NOT_FOUND);
		}
	}

}
