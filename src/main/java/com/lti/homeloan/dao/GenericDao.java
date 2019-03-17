package com.lti.homeloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDao {
	
	@PersistenceContext
	private EntityManager entityManager;
		
	public Object add(Object obj) {
		return entityManager.merge(obj);
	}
	
	public <T> T fetch(Class<T> requiredClass, Object pk) {
		return entityManager.find(requiredClass, pk);
	}
}
