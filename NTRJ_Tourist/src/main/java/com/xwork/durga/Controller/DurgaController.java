package com.xwork.durga.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.ui.Model;

import com.xwork.durga.dto.DurgaDTO;
import com.xwork.durga.services.DurgaServices;

public class DurgaController {
	
	private DurgaServices durgaServices;
	
	private List<Integer> enterPassword =Arrays.asList(12345,23456,3456,456,567,567,6789,7890,89022);
    private List<Number> reEnterPassword =Arrays.asList(12345,23456,3456,456,567,567.6789,7890,89022);
    private List<Number> enterMobileNumber =Arrays.asList(9876547654.876543543,9876543,23456789);
    private List<Integer> noOfMembers =Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    private List<Integer> noOfPlacesToVisit =Arrays.asList(1,2,3,4,5,6,7);
    
    public DurgaController() {
    	System.out.println("Created"+ getClass().getSimpleName());
    }
    
    public String onDurga(Model model) {
    	System.out.println("Running onDurga");
    	model.addAttribute("enterPassword", enterPassword);
    	model.addAttribute("reEnterPassword", reEnterPassword);
    	model.addAttribute("enterMobileNumber", enterMobileNumber);
    	model.addAttribute("noOfMembers", noOfMembers);
    	model.addAttribute("noOfPlacesToVisit", noOfPlacesToVisit);
    	return "Durga";
    }
    
    public String onSearch(int id, Model model) {
    	System.out.println("Running on search for id" +id);
    	DurgaDTO durgaDTO =durgaServices.findById(id);
    	if(durgaDTO!=null) {
    		model.addAttribute("durgaDTO", durgaDTO);
    	}else {
    		model.addAttribute("message", "Data not found");
    	}
    	return "DurgaIdSearch";
    }
    public String onDurga(Model model, DurgaDTO durgaDTO) {
    	System.out.println("Running ondurga in post mapping" + durgaDTO);
    	Set<ConstraintViolation<DurgaDTO>> violations= durgaServices.validateAndSave(durgaDTO);
    	if(violations.isEmpty()) {
    		System.out.println("No violation in controll go to success page");
    		return "Durga";
    	}
    	model.addAttribute("enterPassword", enterPassword);
    	model.addAttribute("reEnterPassword", reEnterPassword);
    	model.addAttribute("enterMobileNumber", enterMobileNumber);
    	model.addAttribute("noOfMembers", noOfMembers);
    	model.addAttribute("noOfPlacesToVisit", noOfPlacesToVisit);
    	model.addAttribute("durgaDTO", durgaDTO);
    	System.out.println("violations in controll");
    	return "Durga";
    }
    public String OnSearchByUserName(String userName, Model model) {
    	System.out.println("Running on search for user Name"+ userName);
    	List<DurgaDTO> durgaDTO =durgaServices.findByUserName(userName);
    	if(durgaDTO!=null) {
    		model.addAttribute("durgaDTO", durgaDTO);
    		return "SearchByUserName";
    	}else {
    		model.addAttribute("message", "data not found");
    		return "SearchByUserName";
    	}
    }
    public String onSearchByEmail(String email, Model model) {
    	System.out.println("Running on search for email"+email);
    	List<DurgaDTO> durgaDTO = durgaServices.findByEmail(email);
    	if(durgaDTO!=null) {
    		model.addAttribute("durgaDTO", durgaDTO);
    		return "SearchByEmail";
    	}else {
    		model.addAttribute("Message"," Data not found");
    		return "SearchByEmail";
    	}
    }
    public String onUpDate(int id, Model model) {
    	System.out.println("Running update on get" +id);
    	DurgaDTO durgaDTO = durgaServices.findById(id);
    	model.addAttribute("enterPassword", enterPassword);
    	model.addAttribute("reEnterPassword", reEnterPassword);
    	model.addAttribute("enterMobileNumber", enterMobileNumber);
    	model.addAttribute("noOfMembers", noOfMembers);
    	model.addAttribute("noOfPlacesToVisit", noOfPlacesToVisit);
    	model.addAttribute("durgaDTO", durgaDTO);
    	return "UpdateDurga";
    }
    public String onUpDate(DurgaDTO durgaDTO, Model model) {
    	System.out.println("Running update on post" +durgaDTO);
    	Set<ConstraintViolation<DurgaDTO>> violations=durgaServices.validateAndSave(durgaDTO);
    	if(violations.size()>0) {
    		model.addAttribute("error", violations);
    	}else {
    		model.addAttribute("Message", "Durga Updated Success");
    	}
    	return "UpdateDurga";
    }
    public String onDelete(int id,Model model) {
    	System.out.println("Running on delet "+id);
    	DurgaDTO durgaDTO = durgaServices.deleteById(id);
    	if(durgaDTO!=null) {
    	model.addAttribute("delete", durgaDTO);
    	model.addAttribute("id", id);
    	return "Delete";
    	}else {
    		model.addAttribute("Message", "Data not found");
    		return "UpdateDurga";
    	}
    }
    
    
    
}
