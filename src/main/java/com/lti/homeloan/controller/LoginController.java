package com.lti.homeloan.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.homeloan.dto.LoginDTO;
import com.lti.homeloan.entity.LoginEntity;
import com.lti.homeloan.service.LoginService;

@Controller
@SessionAttributes("user")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(LoginDTO loginDTO, Map<String, Object> model) {
		LoginEntity e = loginService.login(loginDTO);
		if (e != null) {
			model.put("user", e);
			return "/LoginSuccessful.jsp";
		} else {
			return "/fail.jsp";
		}

	}
	
	 /* @RequestMapping(path = "/forgetPassword", method = RequestMethod.POST)
	  public String loginQA(LoginDTO loginDTO) {
		  
	  }
	  */
	  
	  
	 
}
