package com.lti.homeloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDao {
	
	@PersistenceContext
	private EntityManager entityManager;
		
	public void add(Object obj) {
		entityManager.persist(obj);
	}
	
}
