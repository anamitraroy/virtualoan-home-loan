package com.lti.homeloan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.homeloan.dto.AdminLoginDTO;
import com.lti.homeloan.entity.AdminEntity;
import com.lti.homeloan.entity.ApplicationEntity;
import com.lti.homeloan.entity.LoanEntity;
import com.lti.homeloan.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(path="/adminLogin", method=RequestMethod.POST)
	public String login(AdminLoginDTO loginDTO, Map<String, Object> model) {
		AdminEntity admin = adminService.login(loginDTO);
		if(admin != null) {
			model.put("admin", admin);
			return "/adminDashboard.jsp";
		}
		else
			return "/loginError.jsp";
	}
	
	@RequestMapping(path="/fetchApprovedLoans", method=RequestMethod.GET)
	public String fetchApprovedLoans(Map<String, Object> model) {
		List<LoanEntity> loans = adminService.fetchApprovedLoans();
		model.put("listOfLoans", loans);
		return "/adminViewLoans.jsp";
	}
	
	@RequestMapping(path="/fetchApplications", method=RequestMethod.GET)
	public String fetchPendingApplications(Map<String, Object> model) {
		List<ApplicationEntity> applications = adminService.fetchPendingApplications();
		model.put("listOfApplications", applications);
		return "/adminViewApplications.jsp";
	}
	
	@RequestMapping(path="/viewSingleApplication", method=RequestMethod.GET)
	public String viewSingleApplication(Map<String, Object> model, 
																		@RequestParam("applicationNo") int applicationNumber) {
		ApplicationEntity application = adminService.fetchSingleApplication(applicationNumber);
		model.put("currentApplication", application);
		return "/adminViewSingleApplication.jsp";
	}
	
	@RequestMapping(path="/verifyApplication", method=RequestMethod.GET)
	public String verifyApplication(@RequestParam("applicationNo") int applicationNumber) {
		adminService.verifyApplication(applicationNumber);
		return "/adminDashboard.jsp";
	}
	
	@RequestMapping(path="/approveApplication", method=RequestMethod.GET)
	public String approveApplication(@RequestParam("applicationNo") int applicationNumber) {
		adminService.approveApplication(applicationNumber);
		return "/adminDashboard.jsp";
	}
	
	
}
