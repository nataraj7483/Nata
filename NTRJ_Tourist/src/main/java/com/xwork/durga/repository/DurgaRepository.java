package com.xwork.durga.repository;

import java.util.Collections;
import java.util.List;

import com.xwork.durga.entity.DurgaEntity;

public interface DurgaRepository {
	
	boolean save(DurgaEntity entity);
	
	default DurgaEntity findById(int id) {
		return null;
	}
	
	default List<DurgaEntity> findByUserName(String userName){
		return Collections.emptyList();
	}
	default List<DurgaEntity> findByEmail(String email){
		return Collections.emptyList();
	}
	boolean update(DurgaEntity entity);
	
	default DurgaEntity deletById(int id) {
		return null;
	}

}
