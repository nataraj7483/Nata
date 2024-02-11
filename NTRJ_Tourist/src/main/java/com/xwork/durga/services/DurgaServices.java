package com.xwork.durga.services;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xwork.durga.dto.DurgaDTO;

public interface DurgaServices {
	
	Set<ConstraintViolation<DurgaDTO>> validateAndSave(DurgaDTO durgaDTO);
	
	default DurgaDTO findById(int id) {
		return null;
	}
	default List<DurgaDTO> findByUserName(String userName){
		return Collections.emptyList();
    }
	default DurgaDTO deleteById(int id) {
		return null;
	}
	
	default List<DurgaDTO> findByEmail(String email){
		return Collections.emptyList();
	}
	Set<ConstraintViolation<DurgaDTO>> validateAndUpdate(DurgaDTO durgaDTO);
	
	
}