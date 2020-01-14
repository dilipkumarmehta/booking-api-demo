package com.booking.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.beans.Status;
import com.booking.beans.UserLoginBean;
import com.booking.repository.AccountManagerRepository;
import com.booking.security.config.PasswordEncryptionUtil;

@Service
public class AccountManagerServiceImpl implements AccountManagerService {
	private static Logger logger = LoggerFactory.getLogger(AccountManagerServiceImpl.class);

	@Autowired(required = true)
	private AccountManagerRepository userServiceRepository;

	@Autowired(required = true)
	private EmailService emailService;

	@Override
	public UserLoginBean verifyLoginEmail(UserLoginBean userLoginBean) {
		UserLoginBean findByemailId = userServiceRepository.findByemailId(userLoginBean.getEmailId());
		return findByemailId;
	}

	@Override
	public UserLoginBean registerUser(UserLoginBean loginRequestBean) {
		String encryptedPassword = PasswordEncryptionUtil.encryptedPassword(loginRequestBean.getPassword());
		String encryptedConfPassword = PasswordEncryptionUtil.encryptedPassword(loginRequestBean.getConformPassword());
		loginRequestBean.setPassword(encryptedPassword);
		loginRequestBean.setConformPassword(encryptedConfPassword);

		UserLoginBean register = userServiceRepository.save(loginRequestBean);
		return register;
	}

	@Override
	public Status logIn(UserLoginBean loginRequestBean) {
		Status status = new Status();
		String encryptedPassword = PasswordEncryptionUtil.encryptedPassword(loginRequestBean.getPassword());
		String encryptedConfPassword = PasswordEncryptionUtil.encryptedPassword(loginRequestBean.getConformPassword());
		loginRequestBean.setPassword(encryptedPassword);
		loginRequestBean.setConformPassword(encryptedConfPassword);

		Optional<UserLoginBean> loginUser = userServiceRepository.logIn(loginRequestBean.getPassword(),
				loginRequestBean.getEmailId());
		if (loginUser.isPresent() && loginUser.get().getPassword().equals(loginRequestBean.getPassword())) {
			status.setSuccess_message("Login success");
			status.setSuccess_code("200");
			return status;
		}
		status.setError_message("Invalid user name or password");
		status.setError_code("401");
		return status;
	}

	@Override
	public Status sendEmailToResetPassword(String email) {
		emailService.sendEmail(email);
		return null;
	}
}
