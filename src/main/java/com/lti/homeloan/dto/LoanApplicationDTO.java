package com.lti.homeloan.dto;

import com.lti.homeloan.entity.PropertyEntity;

public class LoanApplicationDTO {
	private PropertyEntity property;
	private String propertyName;
	private String propertyLocation;
	private double estimatedAmount;
	private double requestedAmount;
	private int duration;
	
	
	public PropertyEntity getProperty() {
		return property;
	}
	public void setProperty(PropertyEntity property) {
		this.property = property;
	}
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
	public double getRequestedAmount() {
		return requestedAmount;
	}
	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
