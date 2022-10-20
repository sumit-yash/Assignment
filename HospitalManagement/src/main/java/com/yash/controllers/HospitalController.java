package com.yash.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.Hospital;
import com.yash.entities.RoomCategory;
import com.yash.entities.Speciality;
import com.yash.services.HospitalService;

@RestController
@RequestMapping("/hospital")
@CrossOrigin("*")
public class HospitalController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

	
	@Autowired
	HospitalService hospitalService;
	
//	@PostMapping("/addModel")
//	public ResponseEntity addHospitalModel(@RequestBody HospitalModel hospital) {
//		System.out.println("hospital= "+hospital);
////		Hospital h =modelToEntity(hospital);
//		HospitalModel addHospital = null;
////				entityToModel(hospitalService.addHospital(h));
//		if(addHospital != null) {
//			return new ResponseEntity<HospitalModel>(addHospital,HttpStatus.OK);
//		}else {
//			return new ResponseEntity<HospitalModel>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	@PostMapping("/add")
	public ResponseEntity addHospital(@RequestBody Hospital hospital) {
		logger.info("hospital= "+hospital);
		Hospital addHospital = hospitalService.addHospital(hospital);
//		Hospital addHospital=null;
		if(addHospital != null) {
			return new ResponseEntity<Hospital>(addHospital,HttpStatus.OK);
		}else {
			return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
		}
	}
	
//	private HospitalModel entityToModel(Hospital hs) {
//		System.out.println("hs= "+hs);
//		Arrays[] roomCatArr=null;
//		Arrays[] specialityArr=null;
//		HospitalModel hm =null;
//		if(hs!= null) {
//			hm.setHospitalName(hs.getHospitalName());
//			hm.setRoomCategoryArr(ListToArray(hs.getRoomCategoryList()));
//			hm.setSpecialityArr(ListToArrays(hs.getSpecialityList()));
//		}
//		return hm;
//	}

	private RoomCategory[] ListToArray(List rcl) {
		RoomCategory[] rcArr = null;
		if(rcl != null) {
			for(int i=0;i<rcl.size();i++) {
				rcArr= (RoomCategory[]) rcl.get(i);
			}
		}
		return rcArr;
	}

	private Speciality[] ListToArrays(List rcl) {
		Speciality[] rcArr = null;
		if(rcl != null) {
			for(int i=0;i<rcl.size();i++) {
				rcArr= (Speciality[]) rcl.toArray();
			}
		}
		return rcArr;
	}
	
//	private Hospital modelToEntity(HospitalModel hospital) {
//		System.out.println("hospital= "+hospital);
//		Hospital hs=null;
//		if(hospital != null) {
//			hs.setHospitalName(hospital.getHospitalName());
//			hs.setRoomCategoryList(arrayToList(hospital.getRoomCategoryArr()));
//			hs.setSpecialityList(arrayToList(hospital.getSpecialityArr()));
//		}
//		System.out.println("hs="+hs);
//		return hs;
//	}

	private List<RoomCategory> arrayToList(RoomCategory[] roomCategoryArr) {
		List<RoomCategory> list=new ArrayList<>();
		if(roomCategoryArr != null && roomCategoryArr.length>0) {
			for(int i=0;i<roomCategoryArr.length;i++) {
				list.add(roomCategoryArr[i]);
			}
		}
		return list;
	}

	private List<Speciality> arrayToList(Speciality[] roomCategoryArr) {
		List<Speciality> list=new ArrayList<>();
		if(roomCategoryArr != null && roomCategoryArr.length>0) {
			for(int i=0;i<roomCategoryArr.length;i++) {
				list.add(roomCategoryArr[i]);
			}
		}
		return list;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getHospital(@PathVariable("id") Integer id) {
		Hospital hospital = hospitalService.getHospital(id);
		logger.info(""+hospital);
		if(hospital != null) {
			return new ResponseEntity<Hospital>(hospital,HttpStatus.OK);
		}else {
			return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/address/{address}")
	public ResponseEntity getHospitalByAddress(@PathVariable("address") String address) {
		List<Hospital> hospitals = hospitalService.getHospitalByAddress(address);
		logger.info(""+hospitals);
		if(hospitals != null) {
			return new ResponseEntity<List<Hospital>>(hospitals,HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Hospital>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity getAllHospital() {
		if(hospitalService.getAllHospital()!= null) {
			return new ResponseEntity<List<Hospital>>(hospitalService.getAllHospital(),HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Hospital>>(HttpStatus.NOT_FOUND);
		}
	}
}
