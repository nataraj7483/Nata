package com.xwork.durga.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="ntrj_Tour")
@NamedQuery(name="findByUserName", query ="select ent from DurgaEntity ent where ent.userName=:userName")
public class DurgaEntity {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="user_Name")
	private String userName;
	@Column(name="email")
	private String email;
	@Column(name="enter_Password")
	private int enterPassword;
	@Column(name="re_EnterPassword")
	private int reEnterPassword;
	@Column(name="enter_MobileNumber")
	private long enterMobileNumber;
	@Column(name="no_Of_Members")
	private int noOfMembers;
	@Column(name="no_Of_Places_To_Visit")
	private int noOfPlacesToVisit;
	@Column(name="start")
	private String start;


}
