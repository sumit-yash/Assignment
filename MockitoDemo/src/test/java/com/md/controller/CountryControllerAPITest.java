package com.md.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.md.entities.Country;
import com.md.service.CountryService;


@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.md"})
@ContextConfiguration
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes=CountryControllerAPITest.class)
class CountryControllerAPITest {

	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	CountryController countryController;
	
	@Mock
	CountryService countryService;
	
	List<Country> countries;
	
	Country country;
	
	@BeforeEach
	public void setUp() {
		mockMvc=MockMvcBuilders.standaloneSetup(countryController).build();
	}
	
	
	@Test
	@Order(1)
	public void test_allCountries_success() throws Exception {
		countries=new ArrayList<>();
		countries.add(new Country(11, "India", "Delhi"));
		countries.add(new Country(12, "USA", "Washington"));
		
		when(countryService.getAllCountries()).thenReturn(countries);
		
		mockMvc.perform(get("/allCountries"))
				.andExpect(status().isFound())
				.andDo(print());
	}
	
	@Test
	@Order(2)
	public void test_countryByName_success() throws Exception{
		country=new Country(13,"Australia","Canberra");
		String countryName="Australia";
		when(countryService.getCountryByName(countryName)).thenReturn(country);
		
		mockMvc.perform(get("/country/countryName").param("countryName", countryName))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath(".countryId").value(13))
			.andExpect(MockMvcResultMatchers.jsonPath(".countryName").value("Australia"))			
			.andExpect(MockMvcResultMatchers.jsonPath(".capitalName").value("Canberra"))	
			.andDo(print());
	}
	
	@Test
	@Order(3)
	public void test_countryById_success() throws Exception{
		country=new Country(13,"Australia","Canberra");
		int countryId=13;
		when(countryService.getCountryById(countryId)).thenReturn(country);
		
		mockMvc.perform(get("/country/{id}",countryId))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath(".countryId").value(13))
			.andExpect(MockMvcResultMatchers.jsonPath(".countryName").value("Australia"))
			.andExpect(MockMvcResultMatchers.jsonPath(".capitalName").value("Canberra"))
			.andDo(print());
	}
	
	@Test
	@Order(4)
	public void test_addCountry_success() throws Exception {
		country=new Country(13,"Australia","Canberra");
		when( countryService.addCountry(country)).thenReturn(country);
		
		ObjectMapper mapper=new ObjectMapper();
		String jsonBody = mapper.writeValueAsString(country);
		
		mockMvc.perform(post("/country")
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andDo(print());
		
	}
	
	@Test
	@Order(5)
	public void test_updateCountry_success() throws Exception {
		country=new Country(13,"Australia","Canberra");
		int countryId=13;
		when(countryService.getCountryByName(country.getCountryName())).thenReturn(country);
		when(countryService.updateCountry(country)).thenReturn(country);
		
		ObjectMapper mapper=new ObjectMapper();
		String jsonBody = mapper.writeValueAsString(country);
		
		
		mockMvc.perform(put("/country/{id}",countryId)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath(".capitalName").value( "Canberra"));
			
	}
	
	@Test
	@Order(6)
	public void test_deleteCountry_success() throws Exception {
		country=new Country(13,"Australia","Canberra");
		int countryId=13;
		when(countryService.getCountryById(countryId)).thenReturn(country);
		
		mockMvc.perform(delete("/country/{id}",countryId))
						.andExpect(status().isOk());
	}
	

}
