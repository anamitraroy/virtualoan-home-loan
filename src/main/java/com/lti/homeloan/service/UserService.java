package com.lti.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.homeloan.dao.FileUploadDao;
import com.lti.homeloan.dao.GenericDao;
import com.lti.homeloan.dao.UserDao;
import com.lti.homeloan.dto.FileUploadDTO;
import com.lti.homeloan.dto.LoanApplicationDTO;
import com.lti.homeloan.dto.UserDTO;
import com.lti.homeloan.dto.UserIncomeDetailsDTO;
import com.lti.homeloan.entity.ApplicationEntity;
import com.lti.homeloan.entity.FileUploadEntity;
import com.lti.homeloan.entity.LoanEntity;
import com.lti.homeloan.entity.PropertyEntity;
import com.lti.homeloan.entity.UserEntity;
import com.lti.homeloan.entity.UserIncomeDetailsEntity;

//import oracle.net.aso.l;

@Service
public class UserService {
		
	@Autowired
	private GenericDao genericDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FileUploadDao  fileUploadDao;
	
	@Transactional
	public void register(UserDTO registerDTO) {		//	shouldn't be void. should return something for if-else for success or failure of register
		UserEntity register = new UserEntity();
		register.setFirstName(registerDTO.getFirstName());
		register.setLastName(registerDTO.getLastName());
		register.setMiddleName(registerDTO.getMiddleName());
		register.setEmailId(registerDTO.getEmailId());
		register.setPassword(registerDTO.getPassword());
		register.setAadharNo(registerDTO.getAadharNo());
		register.setPanNo(registerDTO.getPanNo());
		register.setMaritalStatus(registerDTO.getMaritalStatus());
		register.setDob(registerDTO.getDob());
		register.setGender(registerDTO.getGender());
		register.setMobileNo(registerDTO.getMobileNo());
		register.setQuestion(registerDTO.getQuestion());
		register.setAnswer(registerDTO.getAnswer());
		
		genericDao.add(register);
		
	}
	@Transactional
	public void addIncomeDetails(UserIncomeDetailsDTO userIncomeDetailsDTO) {
		UserIncomeDetailsEntity income=new UserIncomeDetailsEntity();
		
		income.setUser(userIncomeDetailsDTO.getUser());
		income.setEmploymentType(userIncomeDetailsDTO.getEmploymentType());
		income.setMonthlyIncome(userIncomeDetailsDTO.getMonthlyIncome());
		income.setOrganisation(userIncomeDetailsDTO.getOrganisation());
		income.setRetirementAge(userIncomeDetailsDTO.getRetirementAge());
		
		genericDao.add(income);
	}
	
	@Transactional
	public PropertyEntity addPropertyDetails(LoanApplicationDTO loanApplicationDTO) {
		PropertyEntity property=new PropertyEntity();
		
		property.setPropertyName(loanApplicationDTO.getPropertyName());
		property.setPropertyLocation(loanApplicationDTO.getPropertyLocation());
		property.setEstimatedAmount(loanApplicationDTO.getEstimatedAmount());
		
		PropertyEntity addedProperty = (PropertyEntity) genericDao.add(property);
		return addedProperty;
	}
	
	@Transactional
	public void addApplicationDetails(LoanApplicationDTO loanApplicationDTO, UserEntity user) {
		
		ApplicationEntity application=new ApplicationEntity();
		
		double maxLoanAmount = 60 * (0.6 * userDao.fetchUserIncomeDetails(user).getMonthlyIncome());
		double rate = 8.5;			//	!!!! Hardcoded !!!!
		application.setUser(user);
		application.setMaximumLoanAmount(maxLoanAmount);
		application.setRequestedLoanAmount(loanApplicationDTO.getRequestedAmount());
		application.setRate(rate);
		application.setDuration(loanApplicationDTO.getDuration());
		application.setProperty(loanApplicationDTO.getProperty());
		application.setIsSent(true);
		application.setIsVerified(false);
		application.setIsApproved(false);
		application.setIsRejected(false);
		
		genericDao.add(application);
	}
	
	@Transactional
	public void fileUpload(FileUploadDTO fileUploadDTO, UserEntity user) {
		FileUploadEntity fileUploadEntity=new FileUploadEntity();
		
		fileUploadEntity.setUser(user);
		fileUploadEntity.setAadharNo(fileUploadDTO.getAadharNo().getOriginalFilename());
		fileUploadEntity.setVoterId(fileUploadDTO.getVoterId().getOriginalFilename());
		fileUploadEntity.setSalarySlip(fileUploadDTO.getSalarySlip().getOriginalFilename());
		fileUploadEntity.setLoa(fileUploadDTO.getLoa().getOriginalFilename());
		fileUploadEntity.setNoc(fileUploadDTO.getNoc().getOriginalFilename());
		fileUploadEntity.setAgreement(fileUploadDTO.getAgreement().getOriginalFilename());
		
		fileUploadDao.addFiles(fileUploadEntity);
	}
	
	public FileUploadEntity getRegisteredUser(UserEntity user) {
		return fileUploadDao.fetch(user);
	}

}