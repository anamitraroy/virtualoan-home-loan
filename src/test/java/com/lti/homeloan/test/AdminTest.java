package com.lti.homeloan.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.homeloan.dao.AdminDao;
import com.lti.homeloan.dto.AdminLoginDTO;
import com.lti.homeloan.entity.AdminEntity;
import com.lti.homeloan.entity.ApplicationEntity;
import com.lti.homeloan.entity.LoanEntity;
import com.lti.homeloan.service.AdminService;

public class AdminTest {

	@Test
	public void adminLoginTest() {
		AdminLoginDTO dto = new AdminLoginDTO();
		dto.setUserName("admin");
		dto.setPassword("admin");
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");
		AdminDao dao = ctx.getBean(AdminDao.class);
		
		System.out.println("Username: " + dao.fetchAdmin(dto).getUserName());
		//System.out.println(dao.fetchAdmin(dto).getPassword());
	}
	
	@Test
	public void adminFetchApprovedLoansTest() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");
		AdminDao dao = ctx.getBean(AdminDao.class);
		
		List<LoanEntity> loans = dao.fetchApprovedLoans();
		for (LoanEntity loanEntity : loans) {
			System.out.print(loanEntity.getLoanAmount() + "\t");
			System.out.print(loanEntity.getDuration() + "\t");
		}
	}
	
	@Test
	public void adminFetchApplicationsTest() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");
		AdminDao dao = ctx.getBean(AdminDao.class);
		
		List<ApplicationEntity> applications = dao.fetchApplications();
		for (ApplicationEntity apps : applications) {
			System.out.print(apps.getApplicationNo() + "\t");
			System.out.print(apps.getRequestedLoanAmount() + "\t");
			/*System.out.print(apps.getRate() + "\t");
			System.out.print(apps.getDuration() + "\t");*/
			System.out.print(apps.getIsSent()+ "\t");
			System.out.print(apps.getIsVerified()+ "\t");
			System.out.println(apps.getIsApproved()+ "\t");
		}
	}
	
	@Test
	public void adminFetchSingleApplication() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");
		AdminDao dao = ctx.getBean(AdminDao.class);
		
		ApplicationEntity application = dao.fetchSingleApplication(101);
		System.out.print(application.getApplicationNo() + "\t");
		System.out.print(application.getRequestedLoanAmount() + "\t");
		System.out.print(application.getUserId() + "\t");
		System.out.println("Is Sent? "+ application.getIsSent());
		System.out.println("Is Verified? "+ application.getIsVerified());
		System.out.println("Is Approved? "+ application.getIsApproved());
	}
	
	@Test
	public void adminVerifyApplication() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");
		AdminDao dao = ctx.getBean(AdminDao.class);
		dao.verifyApplication(100);
	}
}
