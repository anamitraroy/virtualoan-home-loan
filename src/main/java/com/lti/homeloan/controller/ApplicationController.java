package com.lti.homeloan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.homeloan.dto.ApplicationDTO;
import com.lti.homeloan.service.ApplicationService;

@Controller
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@RequestMapping(path = "/application", method = RequestMethod.POST)
	public String sendApplication(ApplicationDTO applicationDTO) {
		applicationService.sendApplication(applicationDTO);
		return "/confirmation.jsp";
	}
	
	/*@RequestMapping(path="/userApplication", method=RequestMethod.GET)
	public String list(Map<String, Object> model) {
		List<ApplicationEntity> userApplications = applicationService.getApplication();
		model.put("listOfApplications", userApplications);
		return "/ApplicationDetails.jsp";
	}*/
}
