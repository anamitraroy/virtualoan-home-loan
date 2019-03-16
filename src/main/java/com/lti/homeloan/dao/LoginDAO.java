package com.lti.homeloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.homeloan.dto.LoginDTO;
import com.lti.homeloan.entity.UserEntity;
import com.lti.homeloan.exception.UserLoginException;

@Repository
public class LoginDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public UserEntity login(LoginDTO loginDTO) throws UserLoginException {

		Query query = entityManager.createQuery(
				"select user from UserEntity as user where user.emailId = :emailId and user.password = :password");
		query.setParameter("emailId", loginDTO.getEmailId());
		query.setParameter("password", loginDTO.getPassword());
		try {
			return (UserEntity) query.getSingleResult();
		} catch (NoResultException nre) {
			throw new UserLoginException("Problem in user credential");
		}
	}
	
	public UserEntity fetchQuestion(LoginDTO loginDTO) {
		Query query = entityManager.createQuery("select a from UserEntity  a where a.emailId =:emailId");
		query.setParameter("emailId", loginDTO.getEmailId());
		return (UserEntity) query.getSingleResult();

	}

	public UserEntity validateAnswer(LoginDTO loginDTO) throws UserLoginException {

		Query query = entityManager.createQuery("select b from UserEntity as b where b.answer = :answer");
		query.setParameter("answer", loginDTO.getAnswer());
		try {
			return (UserEntity) query.getSingleResult();
		} catch (NoResultException e) {
			throw new UserLoginException("Problem in answer selection");
		}
	}

	@Transactional
	public void updatePassword(LoginDTO loginDTO) {

		Query query = entityManager
				.createQuery("update UserEntity as e set e.password=:password where e.emailId=:emailId");
		query.setParameter("emailId", loginDTO.getEmailId());
		query.setParameter("password", loginDTO.getPassword());
		query.executeUpdate();
	}

}
