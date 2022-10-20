package com.yash.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.RoomCategory;
import com.yash.services.RoomCategoryService;

@RestController
@RequestMapping("/roomCategory")
@CrossOrigin("*")
public class RoomCategoryController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(RoomCategoryController.class);

	
	@Autowired
	RoomCategoryService roomCatService;
	
	@PostMapping("/add")
	public ResponseEntity addRoomCategory(@RequestBody RoomCategory roomCategory) {
		RoomCategory addRoomCategory = roomCatService.addRoomCategory(roomCategory);
		if(addRoomCategory!= null) {
			return new ResponseEntity<RoomCategory>(addRoomCategory,HttpStatus.OK);
		}else {
			return new ResponseEntity<RoomCategory>(HttpStatus.NOT_FOUND);
		}

	}
}
