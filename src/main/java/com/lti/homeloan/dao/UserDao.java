package com.lti.homeloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.homeloan.entity.UserEntity;
import com.lti.homeloan.entity.UserIncomeDetailsEntity;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void add(UserEntity register) {
		entityManager.persist(register);
	}
	
	@Transactional
	public void addIncomeDetails(UserIncomeDetailsEntity incomeDetails) {
		entityManager.persist(incomeDetails);
	}

}
