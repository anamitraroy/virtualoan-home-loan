package com.lti.homeloan.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lti.homeloan.dto.LoginDTO;
import com.lti.homeloan.entity.LoginEntity;
import com.lti.homeloan.entity.UserEntity;
import com.lti.homeloan.service.LoginService;

import sun.security.util.Password;

@Controller
@SessionAttributes("user")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(path ="/login", method = RequestMethod.POST)
	public String login(LoginDTO loginDTO, Map<String, Object> model, RedirectAttributes redir, HttpSession session) {
		UserEntity e = loginService.login(loginDTO);
		if (e != null) {
			session.setAttribute("user", e);
			model.put("user", e);
			return "/LoginSuccessful.jsp";
		} else {
			String errorMessage = "Wrong Email or Password. Please try again";
			model.put("error", errorMessage);
			//redir.addFlashAttribute("error", errorMessage);
			return "redirect:/login.jsp";
		}

	}
	
	 /* @RequestMapping(path = "/forgetPassword", method = RequestMethod.POST)
	  public String loginQA(LoginDTO loginDTO) {
		  
	  }
	  */
	  
	  
	 
}
