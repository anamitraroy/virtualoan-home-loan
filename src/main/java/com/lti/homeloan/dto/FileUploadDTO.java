package com.lti.homeloan.dto;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lti.homeloan.entity.UserEntity;


public class FileUploadDTO {
	
	private UserEntity user;
	private MultipartFile aadharCard;
	private MultipartFile voterId;
	private MultipartFile salarySlip;
	private MultipartFile letterOfAgreement;
	private MultipartFile noc;
	private MultipartFile agreement;
	
	
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public MultipartFile getVoterId() {
		return voterId;
	}
	public void setVoterId(MultipartFile voterId) {
		this.voterId = voterId;
	}
	public MultipartFile getSalarySlip() {
		return salarySlip;
	}
	public void setSalarySlip(MultipartFile salarySlip) {
		this.salarySlip = salarySlip;
	}
	public MultipartFile getLetterOfAgreement() {
		return letterOfAgreement;
	}
	public void setLetterOfAgreement(MultipartFile letterOfAgreement) {
		this.letterOfAgreement = letterOfAgreement;
	}
	public MultipartFile getNoc() {
		return noc;
	}
	public void setNoc(MultipartFile noc) {
		this.noc = noc;
	}
	public MultipartFile getAgreement() {
		return agreement;
	}
	public void setAgreement(MultipartFile agreement) {
		this.agreement = agreement;
	}
	public MultipartFile getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(MultipartFile aadharCard) {
		this.aadharCard = aadharCard;
	}

}
