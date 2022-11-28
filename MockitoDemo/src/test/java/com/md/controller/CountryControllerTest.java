package com.md.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.md.entities.Country;
import com.md.service.CountryService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CountryControllerTest {

	@InjectMocks
	CountryController countryController;
	
	@Mock
	CountryService countryService;

	
	List<Country> countries;
	
	Country country;
	
	@Test
	@Order(1)
	public void test_AllCountries_success() {
		countries=new ArrayList<>();
		countries.add(new Country(11, "India", "Delhi"));
		countries.add(new Country(12, "USA", "Washington"));
		
		when(countryService.getAllCountries()).thenReturn(countries);
		
		ResponseEntity<List<Country>> res = countryController.allCountries();
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(countries,res.getBody());
	}
	
	@Test
	@Order(2)
	public void test_CountryByName_success() {
		country=new Country(13,"Australia","Canberra");
		String countryName="Australia";
		when(countryService.getCountryByName(countryName)).thenReturn(country);
		ResponseEntity<Country> res = countryController.countryByName(countryName);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(country, res.getBody());
	}
	
	@Test
	@Order(3)
	public void test_addCountry_success() {
		country=new Country(13,"Australia","Canberra");
		when(countryService.addCountry(country)).thenReturn(country);
		
		ResponseEntity<Country> res = countryController.addCountry(country);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(country, res.getBody());
	}
	
	@Test
	@Order(4)
	public void test_updateCountry_success() {
		country=new Country(13,"Australia","Canberra");
		when(countryService.getCountryByName(country.getCountryName())).thenReturn(country);
		when(countryService.updateCountry(country)).thenReturn(country);
		
		ResponseEntity<Country> res = countryController.updateCountry(country.getCountryId(), country);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(country, res.getBody());
	}
	
	@Test
	@Order(5)
	public void test_countryById_success() {
		country=new Country(14,"Belize","Belmopan");
		int countryId=14;
		
		when(countryService.getCountryById(countryId)).thenReturn(country);
		
		ResponseEntity<Country> res = countryController.countryById(countryId);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(country, res.getBody());
	}
	
	@Test
	@Order(6)
	public void test_deleteCountry_success() {
		country=new Country(14,"Belize","Belmopan");
		int countryId=14;
		when(countryService.getCountryById(countryId)).thenReturn(country);
		
		ResponseEntity<Country> res = countryController.deleteCountry(countryId);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		
	}
}
