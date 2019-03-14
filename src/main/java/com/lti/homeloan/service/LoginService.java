package com.lti.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.homeloan.exception.UserLoginException;
import com.lti.homeloan.dao.LoginDAO;
import com.lti.homeloan.dto.LoginDTO;
import com.lti.homeloan.entity.LoginEntity;

@Component
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

	public LoginEntity login(LoginDTO loginDTO) {
		try {
			LoginEntity loginDetails = loginDAO.login(loginDTO);
			return loginDetails;
		} catch (UserLoginException nre) {
			return null;
		}
	}

}
