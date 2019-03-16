package com.lti.homeloan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.homeloan.dto.AdminLoginDTO;
import com.lti.homeloan.entity.AdminEntity;
import com.lti.homeloan.entity.ApplicationEntity;
import com.lti.homeloan.entity.LoanEntity;
import com.lti.homeloan.exception.AdminLoginException;

@Repository
public class AdminDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public AdminEntity fetchAdmin (AdminLoginDTO loginDTO) throws AdminLoginException {
		Query query = entityManager.createQuery("select admin from AdminEntity as admin where admin.userName = :userName"
																																									+" and admin.password = :password");
		query.setParameter("userName", loginDTO.getUserName());
		query.setParameter("password", loginDTO.getPassword());
		
		try {
			return (AdminEntity) query.getSingleResult();
		} catch (NoResultException e) {
			throw new AdminLoginException("Invalid username or password. Please try again.");
		}
	}
	
	public List<LoanEntity> fetchApprovedLoans() {
		List<LoanEntity> listOfLoans = entityManager.createQuery("select loan from LoanEntity as loan").getResultList();
		return listOfLoans;
	}
	
	public List<ApplicationEntity> fetchApplications() {
		Query query = entityManager.createQuery("select application from ApplicationEntity as application where application.isApproved = false");
		List<ApplicationEntity> listOfApplications = query.getResultList();
		return listOfApplications;
	}
	
	public ApplicationEntity fetchSingleApplication(int applicationNo) {
		Query query = entityManager.createQuery("select application from ApplicationEntity as application where application.applicationNo = :applicationNumber");
		query.setParameter("applicationNumber", applicationNo);
		ApplicationEntity application = (ApplicationEntity) query.getSingleResult();
		return application;
	}
	
	@Transactional
	public void verifyApplication(int applicationNo) {
		Query query = entityManager.createQuery("update ApplicationEntity set isVerified = true where applicationNo = :applicationNumber");
		query.setParameter("applicationNumber", applicationNo).executeUpdate();
	}
	
	@Transactional
	public void approveApplication(int applicationNo) {
		Query query = entityManager.createQuery("update ApplicationEntity set isApproved = true where applicationNo = :applicationNumber");
		query.setParameter("applicationNumber", applicationNo).executeUpdate();
		
		
	}
}
