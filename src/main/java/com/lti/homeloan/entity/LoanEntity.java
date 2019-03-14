package com.lti.homeloan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_loan")
public class LoanEntity {
	@Id
	private int id;
	@Column(name="application_number")
	private int applicationNo;
	@Column(name="applicant_username")
	private String applicantUserName;
	private double amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}
	public String getApplicantUserName() {
		return applicantUserName;
	}
	public void setApplicantUserName(String applicantUserName) {
		this.applicantUserName = applicantUserName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
