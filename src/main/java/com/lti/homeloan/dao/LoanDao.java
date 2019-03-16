package com.lti.homeloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.lti.homeloan.entity.LoanEntity;

@Repository
public class LoanDao { 
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addLoanDetails(LoanEntity loanEntity) {
		entityManager.persist(loanEntity);
	}
}
