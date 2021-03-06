package com.lti.homeloan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TBL_HOMELOAN_PROPERTYDETAILS")
public class PropertyEntity {
	
	@Id
	@GenericGenerator(name="propertySeq",strategy="increment")
	@GeneratedValue(generator="propertySeq") 
	private int id;
	
	private String propertyName;
	private String propertyLocation;
	private double estimatedAmount;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyLocation() {
		return propertyLocation;
	}
	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}
	public double getEstimatedAmount() {
		return estimatedAmount;
	}
	public void setEstimatedAmount(double estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}
	
}
