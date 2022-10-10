package com.yash.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.RoomCategoryDao;
import com.yash.entities.RoomCategory;
import com.yash.services.RoomCategoryService;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService{
	
	@Autowired
	RoomCategoryDao catDao;

	@Override
	public RoomCategory addRoomCategory(RoomCategory roomCategory) {
		RoomCategory addRoomCategory=new RoomCategory();
		if(roomCategory!= null) {
			addRoomCategory=roomCategory;
			addRoomCategory=catDao.save(addRoomCategory);
		}
		return addRoomCategory;
	}

}
