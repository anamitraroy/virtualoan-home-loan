package com.lti.homeloan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.homeloan.dao.AdminDao;
import com.lti.homeloan.dto.AdminLoginDTO;
import com.lti.homeloan.entity.AdminEntity;
import com.lti.homeloan.entity.ApplicationEntity;
import com.lti.homeloan.entity.LoanEntity;
import com.lti.homeloan.exception.AdminLoginException;


@Component
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	public AdminEntity login(AdminLoginDTO loginDTO) {		//	shouldn't be void. should return something for if-else for success or failure of register		
		try {
			AdminEntity adminDetails = adminDao.fetchAdmin(loginDTO);
			return adminDetails;
		} catch (AdminLoginException e) {
			return null;
		}
	}
	
	public List<LoanEntity> fetchApprovedLoans() {
		return adminDao.fetchApprovedLoans();
	}
	
	public List<ApplicationEntity> fetchPendingApplications() {
		return adminDao.fetchApplications();
	}
	
	public ApplicationEntity fetchSingleApplication(int applicationNo) {
		return adminDao.fetchSingleApplication(applicationNo);
	}
	
	public void verifyApplication(int applicationNo) {
		adminDao.verifyApplication(applicationNo);
	}
}
