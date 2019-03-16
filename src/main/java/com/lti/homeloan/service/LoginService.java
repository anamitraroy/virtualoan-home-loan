package com.lti.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.homeloan.dao.LoginDAO;
import com.lti.homeloan.dto.LoginDTO;
import com.lti.homeloan.entity.UserEntity;
import com.lti.homeloan.exception.UserLoginException;

@Component
public class LoginService {
	@Autowired
	private LoginDAO loginDAO;

	public UserEntity login(LoginDTO loginDTO) {
		try {
			UserEntity loginDetails = loginDAO.login(loginDTO);
			return loginDetails;
		} catch (UserLoginException nre) {
			return null;

		}
	}
	
	public UserEntity checkEmail(LoginDTO loginDTO) {
		return loginDAO.fetchQuestion(loginDTO);
	}

	public boolean checkAnswer(LoginDTO loginDTO) {
		try {
			UserEntity ans = loginDAO.validateAnswer(loginDTO);
			return true;
		}catch (UserLoginException e) {
			return false;
		}
	}

	public void resetPassword(LoginDTO loginDTO) {
		loginDAO.updatePassword(loginDTO);
	}


}
