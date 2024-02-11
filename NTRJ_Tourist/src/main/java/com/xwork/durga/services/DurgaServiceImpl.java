package com.xwork.durga.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xwork.durga.dto.DurgaDTO;
import com.xwork.durga.entity.DurgaEntity;
import com.xwork.durga.repository.DurgaRepository;

public class DurgaServiceImpl implements DurgaServices{
	
	private DurgaRepository durgaRepository;
	
	public DurgaServiceImpl() {
		System.out.println("created"+getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<DurgaDTO>> validateAndSave(DurgaDTO durgaDTO) {
		ValidatorFactory validatorFactory=Validation.buildDefaultValidatorFactory();
		Validator validator=validatorFactory.getValidator();
		Set<ConstraintViolation<DurgaDTO>> violations=validator.validate(durgaDTO);
		if(violations!=null && !violations.isEmpty()) {
			System.err.println("Violations in dto"+durgaDTO);
			return violations;
		}
		else {
			System.out.println("violations not there in dto can save");
			DurgaEntity durgaEntity= new DurgaEntity();
			durgaEntity.setUserName(durgaDTO.getUserName());
			durgaEntity.setEmail(durgaDTO.getEmail());
			durgaEntity.setEnterPassword(durgaDTO.getEnterPassword());
			durgaEntity.setReEnterPassword(durgaDTO.getReEnterPassword());
			durgaEntity.setEnterMobileNumber(durgaDTO.getEnterMobileNumber());
			durgaEntity.setNoOfMembers(durgaDTO.getNoOfMembers());
			durgaEntity.setNoOfPlacesToVisit(durgaDTO.getNoOfPlacesToVisit());
			durgaEntity.setStart(durgaDTO.getStart());
			boolean save= durgaRepository.save(durgaEntity);
			System.out.println("Entity data is saved"+save);
			return Collections.emptySet();
		}
		
	}
	public DurgaDTO findById(int id){
		if(id>0) {
			DurgaEntity durgaEntity= durgaRepository.findById(id);
			if(durgaEntity!=null) {
				System.out.println("Entity found in service for id"+id);
				DurgaDTO durgaDTO= new DurgaDTO();
				durgaDTO.setUserName(durgaEntity.getUserName());
				durgaDTO.setEmail(durgaEntity.getEmail());
				durgaDTO.setEnterPassword(durgaEntity.getEnterPassword());
				durgaDTO.setReEnterPassword(durgaEntity.getReEnterPassword());
				durgaDTO.setEnterMobileNumber(durgaEntity.getEnterMobileNumber());
				durgaDTO.setNoOfMembers(durgaEntity.getNoOfMembers());
				durgaDTO.setNoOfPlacesToVisit(durgaEntity.getNoOfPlacesToVisit());
				durgaDTO.setStart(durgaEntity.getStart());
				return durgaDTO;
			}
		}
		return DurgaServices.super.findById(id);
		
	}
	public List<DurgaDTO> findByUserName(String userName){
		System.out.println("Running findByUserName in service"+ userName);
		if(userName!=null && !userName.isEmpty()) {
			System.out.println("userName is valid calling repo");
			List<DurgaEntity> durgaEntity= durgaRepository.findByUserName(userName);
			List<DurgaDTO> durgaDTO= new ArrayList<DurgaDTO>();
			for(DurgaEntity entity :durgaEntity) {
			DurgaDTO dto= new DurgaDTO();	
			dto.setUserName(entity.getUserName());
			dto.setEmail(entity.getEmail());
			dto.setEnterPassword(entity.getEnterPassword());
			dto.setReEnterPassword(entity.getReEnterPassword());
			dto.setEnterMobileNumber(entity.getEnterMobileNumber());
			dto.setNoOfMembers(entity.getNoOfMembers());
			dto.setNoOfPlacesToVisit(entity.getNoOfPlacesToVisit());
			dto.setStart(entity.getStart());
			dto.setId(entity.getId());
			durgaDTO.add(dto);
			}
			System.out.println("size in dto"+durgaEntity.size());
			System.out.println("size in entity" +durgaEntity.size());
			return durgaDTO;
		}else {
			System.err.println("Name is valid");
		}
		return DurgaServices.super.findByUserName(userName);
	}
	
	public List<DurgaDTO> findByEmail(String email){
		System.out.println("Running findBYEmail in service"+ email);
		if(email!=null &&!email.isEmpty()) {
			System.out.println("email is valid calling repo");
			List<DurgaEntity> durgaEntity= durgaRepository.findByEmail(email);
			List<DurgaDTO> durgaDTO= new ArrayList<DurgaDTO>();
			for(DurgaEntity entity :durgaEntity) {
				DurgaDTO dto =new DurgaDTO();
				dto.setUserName(entity.getUserName());
				dto.setEmail(entity.getEmail());
				dto.setEnterPassword(entity.getEnterPassword());
				dto.setReEnterPassword(entity.getReEnterPassword());
				dto.setEnterMobileNumber(entity.getEnterMobileNumber());
				dto.setNoOfMembers(entity.getNoOfMembers());
				dto.setNoOfPlacesToVisit(entity.getNoOfPlacesToVisit());
				dto.setStart(entity.getStart());
				dto.setId(entity.getId());
				durgaDTO.add(dto);
			}
			System.out.println("Size in dto"+ durgaEntity.size());
			System.out.println("Size in entity"+ durgaDTO.size());
            return durgaDTO;
		}else {
			System.err.println("Email is valid");
		}
		return DurgaServices.super.findByEmail(email);
	}
	public Set<ConstraintViolation<DurgaDTO>> validateAndUpdate(DurgaDTO durgaDTO){
		ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<DurgaDTO>> violations= validator.validate(durgaDTO);
		if(violations!=null && !violations.isEmpty()) {
			System.err.println("Violation in DTO"+ durgaDTO);
			return violations;
		}else {
			System.out.println("violation is not there in dto can save");
			DurgaEntity durgaEntity = new DurgaEntity();
			durgaEntity.setUserName(durgaDTO.getUserName());
			durgaEntity.setEmail(durgaDTO.getEmail());
			durgaEntity.setEnterPassword(durgaDTO.getEnterPassword());
			durgaEntity.setReEnterPassword(durgaDTO.getReEnterPassword());
			durgaEntity.setEnterMobileNumber(durgaDTO.getEnterMobileNumber());
			durgaEntity.setNoOfMembers(durgaDTO.getNoOfMembers());
			durgaEntity.setNoOfPlacesToVisit(durgaDTO.getNoOfPlacesToVisit());
			durgaEntity.setStart(durgaDTO.getStart());
			durgaEntity.setId(durgaDTO.getId());
			boolean saved= durgaRepository.update(durgaEntity);
			System.out.println("entity data is saved");
			return Collections.emptySet();
		}
	}
	public DurgaDTO deleteById(int id) {
		if(id>0) {
			DurgaEntity durgaEntity = durgaRepository.deletById(id);
			DurgaDTO durgaDTO = new DurgaDTO();
			durgaDTO.setUserName(durgaEntity.getUserName());
			durgaDTO.setEmail(durgaEntity.getEmail());
			durgaDTO.setEnterPassword(durgaEntity.getEnterPassword());
			durgaDTO.setReEnterPassword(durgaEntity.getReEnterPassword());
			durgaDTO.setEnterMobileNumber(durgaEntity.getEnterMobileNumber());
			durgaDTO.setNoOfMembers(durgaEntity.getNoOfMembers());
			durgaDTO.setNoOfPlacesToVisit(durgaEntity.getNoOfPlacesToVisit());
			durgaDTO.setStart(durgaEntity.getStart());
			durgaDTO.setId(durgaEntity.getId());
			return durgaDTO;
			
		}
		return DurgaServices.super.deleteById(id);
	}
	
	
	
	
	

}
