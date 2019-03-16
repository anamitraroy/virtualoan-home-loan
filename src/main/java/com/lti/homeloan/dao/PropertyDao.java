package com.lti.homeloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.lti.homeloan.entity.PropertyEntity; 

@Repository

public class PropertyDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addPropertyDetails(PropertyEntity propertyEntity) {
		entityManager.persist(propertyEntity);
	}
}
