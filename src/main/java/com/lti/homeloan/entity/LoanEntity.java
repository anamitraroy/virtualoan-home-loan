package com.lti.homeloan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TBL_HOMELOAN_LOANDETAILS")
public class LoanEntity { 
	
	@Id
	@GenericGenerator(name="inc",strategy="increment")
	@GeneratedValue(generator="inc") 
	private int id;
	
	@OneToOne(mappedBy="applicationNo",cascade=CascadeType.ALL)
	private ApplicationEntity application;
	
	@ManyToOne
	private UserEntity user;
	
	private int duration;
	
	private double rate;
	
	private String dateOfCreation;
	
		
	public String getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public ApplicationEntity getApplicationEntity() {
		return application;
	}
	public void setApplicationEntity(ApplicationEntity application) {
		this.application = application;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ApplicationEntity getApplication() {
		return application;
	}
	public void setApplication(ApplicationEntity application) {
		this.application = application;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	

}
