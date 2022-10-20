package com.yash.serviceImpls;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.yash.dao.PatientDao;
import com.yash.entities.Patient;

@RunWith(MockitoJUnitRunner.class)
class PatientServiceImplTest {
	
	@InjectMocks
	PatientServiceImpl sut;
	
	@Mock
	PatientDao patientDao;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	Patient patientTest=new Patient(16, "sumit", "sunil", "abhyankar", "ssa@gmail.com", "ssa");
//	Patient patientTest=null;

	@Test
	void getPatientByEmailAndPasswordTest() {
//		fail("Not yet implemented");	
//		Patient patient =
		Mockito.when(sut.getPatientByEmailAndPassword("ssa@gmail.com","ssa")).thenReturn(patientTest);
		assertEquals(patientTest,sut.getPatientByEmailAndPassword("ssa@gmail.com","ssa"));
	}

	

}
