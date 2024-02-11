package com.xwork.durga.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DurgaDTO {
	
	private int id;
	@NotBlank(message="userName can't be blank")
	@Size(min=3, max=40, message="userName should be mare thane3 or less than 40")
	private String userName;
	@NotBlank(message="E-mail can't be blank")
	@Size(min=3, max=40, message="email should be mare thane3 or less than 40")
	private String email;
	@NotNull(message= "password can't be null")
	@Min(value=1, message= "password can't be less than 0")
	private int enterPassword;
	@NotNull(message= "password can't be null")
	@Min(value=1, message= "password can't be less than 0")
	private int reEnterPassword;
	@NotNull(message= "mobile numberCan't be null")
	@Min(value=1, message ="mobile number can't be less than 0")
	private long enterMobileNumber;
	@NotNull(message="Vehicle type can't be null")
	@Size(min=3, max=45, message="vehicle type be more then 3 or less than 45")
	private int noOfMembers;
	@NotBlank(message="from can't be blank")
	@Size(min=3 , max=45, message="from address should be more than 3 or less than 45")
	private int noOfPlacesToVisit;
	@NotBlank(message="to can't be blank")
	@Size(min=3 , max=45, message="to address should be more than 3 or less than 45")
	private String start;

}
