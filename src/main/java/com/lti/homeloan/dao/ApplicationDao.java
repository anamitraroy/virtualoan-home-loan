package com.lti.homeloan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.homeloan.entity.ApplicationEntity;


@Repository
public class ApplicationDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void add(ApplicationEntity application) {
		entityManager.persist(application);
	}

	public List<ApplicationEntity> fetchbyusername(String username) {
		String jpql = "select applicationEntity from ApplicationEntity as applicationEntity where applicationEntity.username like :uname";
		
		Query q=entityManager.createQuery(jpql);
		q.setParameter("uname", username);
		List<ApplicationEntity> application = q.getResultList();
		
		return application;
		
	}

	public  List<ApplicationEntity> fetchAll() {
		return entityManager.createQuery("select applicationEntity from ApplicationEntity as applicationEntity").getResultList();
	}
}
