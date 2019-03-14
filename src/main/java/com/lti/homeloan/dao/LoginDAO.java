package com.lti.homeloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.lti.homeloan.dto.LoginDTO;
import com.lti.homeloan.entity.LoginEntity;
import com.lti.homeloan.exception.UserLoginException;

@Repository
public class LoginDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public LoginEntity login(LoginDTO loginDTO) throws UserLoginException {
		Query query = entityManager.createQuery(
												"select user from LoginEntity as user where user.userName = :userName and"
																										+ " user.password = :password");
		query.setParameter("userName", loginDTO.getUserName());
		query.setParameter("password", loginDTO.getPassword());
		try {
			return (LoginEntity) query.getSingleResult();
		} catch (NoResultException nre) {
			throw new UserLoginException("Problem in user credentials");
		}
	}
}
