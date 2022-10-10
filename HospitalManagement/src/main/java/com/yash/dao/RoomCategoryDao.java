package com.yash.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.entities.RoomCategory;

@Repository
public interface RoomCategoryDao extends JpaRepository<RoomCategory, Integer>{

}
