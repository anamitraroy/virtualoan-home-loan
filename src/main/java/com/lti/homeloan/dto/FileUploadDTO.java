package com.lti.homeloan.dto;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


public class FileUploadDTO {

	private MultipartFile aadharNo;
	private MultipartFile voterId;
	private MultipartFile salarySlip;
	private MultipartFile loa;
	private MultipartFile noc;
	private MultipartFile agreement;
	
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
	public MultipartFile getLoa() {
		return loa;
	}
	public void setLoa(MultipartFile loa) {
		this.loa = loa;
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
	public MultipartFile getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(MultipartFile aadharNo) {
		this.aadharNo = aadharNo;
	}

}
