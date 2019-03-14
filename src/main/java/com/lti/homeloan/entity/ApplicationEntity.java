package com.lti.homeloan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name="Test_application")
public class ApplicationEntity {
	
	@Id
	private int id;
	@Column(name="application_no")
	private int applicationNo;
	@Column(name="user_id")
	private int userId;
	@Column(name="maximum_loan_amount")
	private double maximumLoanAmount;
	@Column(name="requested_loan_amount")
	private double requestedLoanAmount;
	private double rate;
	private int duration;
	@Column(name="property_id")
	private int propertyId;
	@Column(name="is_sent")
	@Type(type="yes_no")
	private boolean isSent;
	@Column(name="is_verified")
	@Type(type="yes_no")
	private boolean isVerified;
	@Column(name="is_approved")
	@Type(type="yes_no")
	private boolean isApproved;
	
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getMaximumLoanAmount() {
		return maximumLoanAmount;
	}
	public void setMaximumLoanAmount(double maximumLoanAmount) {
		this.maximumLoanAmount = maximumLoanAmount;
	}
	public double getRequestedLoanAmount() {
		return requestedLoanAmount;
	}
	public void setRequestedLoanAmount(double requestedLoanAmount) {
		this.requestedLoanAmount = requestedLoanAmount;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public boolean getIsSent() {
		return isSent;
	}
	public void setIsSent(boolean isSent) {
		this.isSent = isSent;
	}
	public boolean getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

}
