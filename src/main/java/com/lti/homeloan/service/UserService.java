package com.lti.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.homeloan.dao.FileUploadDao;
import com.lti.homeloan.dao.GenericDao;
import com.lti.homeloan.dto.FileUploadDTO;
import com.lti.homeloan.dto.LoanApplicationDTO;
import com.lti.homeloan.dto.UserDTO;
import com.lti.homeloan.dto.UserIncomeDetailsDTO;
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
		
		income.setUserId(userIncomeDetailsDTO.getUserId());
		income.setEmploymentType(userIncomeDetailsDTO.getEmploymentType());
		income.setMonthlyIncome(userIncomeDetailsDTO.getMonthlyIncome());
		income.setOrganisation(userIncomeDetailsDTO.getOrganisation());
		income.setRetirementAge(userIncomeDetailsDTO.getRetirementAge());
		
		genericDao.add(income);
	}
	
	@Transactional
	public void addPropertyDetails(LoanApplicationDTO loanApplicationDTO) {
		PropertyEntity property=new PropertyEntity();
		
		property.setPropertyName(loanApplicationDTO.getPropertyName());
		property.setPropertyLocation(loanApplicationDTO.getPropertyLocation());
		property.setEstimatedAmount(loanApplicationDTO.getEstimatedAmount());
		
		genericDao.add(property);
	}
	
	@Transactional
	public void addLoanDetails(LoanApplicationDTO loanApplicationDTO) {
		LoanEntity loan=new LoanEntity();
		
		loan.setDuration(loanApplicationDTO.getDuration());
		loan.setLoanAmount(loanApplicationDTO.getLoanAmount());
		
		genericDao.add(loan);
	}
	
	@Transactional
	public void fileUpload(FileUploadDTO fileUploadDTO, int userId) {
		FileUploadEntity fileUploadEntity=new FileUploadEntity();
		
		fileUploadEntity.setId(userId);
		fileUploadEntity.setAadharNo(fileUploadDTO.getAadharNo().getOriginalFilename());
		fileUploadEntity.setVoterId(fileUploadDTO.getVoterId().getOriginalFilename());
		fileUploadEntity.setSalarySlip(fileUploadDTO.getSalarySlip().getOriginalFilename());
		fileUploadEntity.setLoa(fileUploadDTO.getLoa().getOriginalFilename());
		fileUploadEntity.setNoc(fileUploadDTO.getNoc().getOriginalFilename());
		fileUploadEntity.setAgreement(fileUploadDTO.getAgreement().getOriginalFilename());
		
		fileUploadDao.addFiles(fileUploadEntity);
	}
	
	public FileUploadEntity getRegisteredUser(int id) {
		return fileUploadDao.fetch(id);
	}

}