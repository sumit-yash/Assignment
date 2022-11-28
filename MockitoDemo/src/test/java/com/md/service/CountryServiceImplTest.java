package com.md.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import com.md.entities.Country;
import com.md.repository.CountryRepository;

@SpringBootTest(classes= {CountryServiceImplTest.class})
@TestMethodOrder(OrderAnnotation.class)
class CountryServiceImplTest {
	@Mock
	CountryRepository countryRepo;

	@InjectMocks
	CountryServiceImpl countryService;
	
	List<Country> countries;
	
	Country country;
	
	@Test
	@Order(1)
	public void test_getAllCountries_success() {
		countries=new ArrayList<>();
		countries.add(new Country(11, "India", "Delhi"));
		countries.add(new Country(12, "USA", "Washington"));
		
		
		when(countryRepo.findAll()).thenReturn(countries);
		
		assertEquals(2, countryService.getAllCountries().size());
	}
	
	@Test
	@Order(2)
	public void test_getCountryByName_success() {
		country=new Country(13,"Australia","Canberra");
		String countryName="Australia";
		when(countryRepo.findByCountryName(countryName)).thenReturn(country);
		assertEquals(country,countryService.getCountryByName(countryName));
		assertEquals("Canberra",countryService.getCountryByName(countryName).getCapitalName());
	}
	
	@Test
	@Order(3)
	public void test_addCountry_success() {
		country=new Country(14,"Belize","Belmopan");
		
		when(countryRepo.save(country)).thenReturn(country);
		
		assertEquals(country,countryService.addCountry(country));
		assertEquals("Belmopan",countryService.addCountry(country).getCapitalName());
	}
	
	@Test
	@Order(4)
	public void test_updateCountry_success() {
		country=new Country(15,"Kazakhstan","Astana");
		
		when(countryRepo.save(country)).thenReturn(country);
		assertEquals(country,countryService.updateCountry(country));
	}
	
	@Test
	@Order(5)
	public void test_getCountryById_success() {
		countries=new ArrayList<>();
		countries.add(new Country(11, "India", "Delhi"));
		countries.add(new Country(12, "USA", "Washington"));
		
		when(countryRepo.findAll()).thenReturn(countries);
		
		int countryId=12;
		assertEquals("Washington",countryService.getCountryById(countryId).getCapitalName());
	}
	
	@Test
	@Order(6)
	public void test_deleteCountry_success() {
		country=new Country(15,"Kazakhstan","Astana");
		countryService.deleteCountry(country);
		
		verify(countryRepo,times(1)).delete(country);
	}

}
