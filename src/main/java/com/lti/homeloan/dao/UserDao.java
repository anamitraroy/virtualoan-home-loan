package com.lti.homeloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.homeloan.entity.UserEntity;
import com.lti.homeloan.entity.UserIncomeDetailsEntity;

@Repository
public class UserDao extends GenericDao {

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
	
	public UserIncomeDetailsEntity fetchUserIncomeDetails(UserEntity userEntity) {
		Query query = entityManager.createQuery("select user from UserIncomeDetailsEntity as user "
																+ "where user.id = :userEntityId");
		return (UserIncomeDetailsEntity) query.setParameter("userEntityId", userEntity.getId()).getSingleResult();
	}
}
