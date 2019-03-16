package com.lti.homeloan.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.homeloan.dto.FileUploadDTO;
import com.lti.homeloan.dto.LoanApplicationDTO;
import com.lti.homeloan.dto.UserDTO;
import com.lti.homeloan.dto.UserIncomeDetailsDTO;
import com.lti.homeloan.entity.FileUploadEntity;
import com.lti.homeloan.entity.PropertyEntity;
import com.lti.homeloan.entity.UserEntity;
import com.lti.homeloan.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path="/register", method = RequestMethod.POST)
	public String register(UserDTO registerDTO,Map<String, Object> model) {
		userService.register(registerDTO);
		model.put("registrationDetails", registerDTO);
		return "/confirmation.jsp";
	}
	
	@RequestMapping(path="/incomeDetails",method=RequestMethod.POST)
	public String addIncomeDetails(UserIncomeDetailsDTO userIncomeDetailsDTO,Map<String,Object> model) {
		userService.addIncomeDetails(userIncomeDetailsDTO);
		model.put("incomeDetails", userIncomeDetailsDTO);
		return "redirect:/loanDetails.jsp";
	}
	
	@RequestMapping(path="/loanDetails",method=RequestMethod.POST)
	public String addLoanApplication(LoanApplicationDTO loanApplicationDTO, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		PropertyEntity addedProperty = userService.addPropertyDetails(loanApplicationDTO);
		loanApplicationDTO.setProperty(addedProperty);
		userService.addApplicationDetails(loanApplicationDTO, user);
		return"/confirmationLoanDetails.jsp";
	}
	
	@RequestMapping(path="/fileUpload" ,method=RequestMethod.POST)
	public String fileUpload(FileUploadDTO fileUploadDTO, Map<String, Object> model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		int userId = user.getId();
		
		//TODO : rename the file since two users can upload file of same name
		File targetDir1 = new File("d:/uploads/" + userId + "-" + fileUploadDTO.getAadharCard().getOriginalFilename()); 
		File targetDir2 = new File("d:/uploads/" + userId + "-" + fileUploadDTO.getVoterId().getOriginalFilename()); 
		File targetDir3 = new File("d:/uploads/" + userId + "-" + fileUploadDTO.getSalarySlip().getOriginalFilename()); 
		File targetDir4 = new File("d:/uploads/" + userId + "-" + fileUploadDTO.getLetterOfAgreement().getOriginalFilename()); 
		File targetDir5 = new File("d:/uploads/" + userId + "-" +  fileUploadDTO.getNoc().getOriginalFilename()); 
		File targetDir6 = new File("d:/uploads/" + userId + "-" + fileUploadDTO.getAgreement().getOriginalFilename()); 
		
		try {
			fileUploadDTO.getAadharCard().transferTo(targetDir1);
			fileUploadDTO.getVoterId().transferTo(targetDir2);
			fileUploadDTO.getSalarySlip().transferTo(targetDir3);
			fileUploadDTO.getLetterOfAgreement().transferTo(targetDir4);
			fileUploadDTO.getNoc().transferTo(targetDir5);
			fileUploadDTO.getAgreement().transferTo(targetDir6);
			
		}
		catch (IOException e) {
			e.printStackTrace(); //if copy fails, throw an exception instead
		}
		
		
		userService.fileUpload(fileUploadDTO, user);
		
		model.put("FileUpload", fileUploadDTO);
		
		return "/confirmationUpload.jsp";
	}
	
/*	@RequestMapping(path="/fetch", method=RequestMethod.GET)
	public String list(@RequestParam int id, Map<String, Object> model, HttpServletRequest request) {
		FileUploadEntity fileUploadEntity = userService.getRegisteredUser(id);
		
		String appRoot = request.getServletContext().getRealPath("/");
		File srcFile = new File("d:/uploads/" + fileUploadEntity.getProfilePicFileName());
		File destFile = new File(appRoot + "/uploads/"+fileUploadEntity.getProfilePicFileName());
		System.out.println(appRoot);
		System.out.println(srcFile.getName());
		System.out.println(destFile.getName());
		
		try {
			FileUtils.copyFile(srcFile,destFile);
		}
		catch (IOException e) {
			e.printStackTrace(); //if copy fails, throw an exception instead
		}
		
		model.put("user", fileUploadEntity);
		return "/fileFetch.jsp";
	}*/
}
