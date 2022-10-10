package com.yash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.RoomCategory;
import com.yash.services.RoomCategoryService;

@RestController
@RequestMapping("/roomCategory")
public class RoomCategoryController {
	
	@Autowired
	RoomCategoryService roomCatService;
	
	@PostMapping("/add")
	public RoomCategory addRoomCategory(@RequestBody RoomCategory roomCategory) {
		RoomCategory addRoomCategory = roomCatService.addRoomCategory(roomCategory);
		return addRoomCategory;
	}
}
