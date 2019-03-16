package com.lti.homeloan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_HOMELOAN_UPLOADDOCUMENT")
public class FileUploadEntity {
	
	@Id
	@Column(name="user_id")
	private UserEntity user;
	private String aadharNo;
	private String voterId;
	private String salarySlip;
	private String letterOfAgreement;
	private String noc;
	private String agreement;
	
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	public String getSalarySlip() {
		return salarySlip;
	}
	public void setSalarySlip(String salarySlip) {
		this.salarySlip = salarySlip;
	}
	public String getLetterOfAgreement() {
		return letterOfAgreement;
	}
	public void setLetterOfAgreement(String letterOfAgreement) {
		this.letterOfAgreement = letterOfAgreement;
	}
	public String getNoc() {
		return noc;
	}
	public void setNoc(String noc) {
		this.noc = noc;
	}
	public String getAgreement() {
		return agreement;
	}
	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	
	
	
}
