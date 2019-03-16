package com.lti.homeloan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name="Test_application")
public class ApplicationEntity {
	
	@Id
	@GenericGenerator(name="inc",strategy="increment")
	@GeneratedValue(generator="inc")
	@Column(name="application_no")
	private int applicationNo;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	@Column(name="maximum_loan_amount")
	private double maximumLoanAmount;
	
	@Column(name="requested_loan_amount")
	private double requestedLoanAmount;
	
	private double rate;
	
	private int duration;
	
	@ManyToOne
	private PropertyEntity property;
	
	@Column(name="is_sent")
	@Type(type="yes_no")
	private boolean isSent;
	
	@Column(name="is_verified")
	@Type(type="yes_no")
	private boolean isVerified;
	
	@Column(name="is_approved")
	@Type(type="yes_no")
	private boolean isApproved;
	
	@Column(name="is_rejected")
	@Type(type="yes_no")
	private boolean isRejected;
	
	public int getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
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
	public PropertyEntity getProperty() {
		return property;
	}
	public void setProperty(PropertyEntity property) {
		this.property = property;
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
	public boolean getIsRejected() {
		return isRejected;
	}
	public void setIsRejected(boolean isRejected) {
		this.isRejected = isRejected;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}

}
