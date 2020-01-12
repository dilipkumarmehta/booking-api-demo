package com.booking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.beans.Password;
import com.booking.beans.Status;
import com.booking.beans.User;
import com.booking.repository.UserServiceRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required = true)
	private UserServiceRepository userServiceRepository;

	@Override
	public Status signUp(User user) {
		//userServiceRepository.save(user);
		Status status = new Status();
		if (user != null) {
			long mobileNmber = user.getMobileNmber();
			Optional<User> findById = userServiceRepository.findBymobileNmber(mobileNmber);
			if (findById.isPresent() && findById.get().getMobileNmber() == user.getMobileNmber()) {
				status.setMessage("Mobile number already exist");
				return status;
			}
			if (!findById.isPresent() && isValidUser(user)) {
				userServiceRepository.save(user);
				status.setMessage("Registration successfully completed");
				return status;
			}
			status.setMessage("Invalid Mobile Muber");
		}
		return status;

	}

	private boolean isValidUser(User user) {
		int mobileleng = String.valueOf(user.getMobileNmber()).length();
		int passwordlen = user.getPassword().length();
		if (mobileleng == 10 && passwordlen > 5) {
			return true;
		}
		return false;

	}

	@Override
	public Status logIn(User user) {
		Status status = new Status();
		long mobilenumber = user.getMobileNmber();
		String password = user.getPassword();
		Optional<User> loginUser = userServiceRepository.logIn(mobilenumber, password);
		if (loginUser.isPresent() && loginUser.get().getPassword().equals(password)
				&& loginUser.get().getMobileNmber() == mobilenumber) {
			status.setMessage("Login success");
			return status;
		}
		status.setMessage("Invalid user name or password");
		return status;
	}

	@Override
	public Status logOut(String userId) {
		return null;
	}

	@Override
	public Status changepasswor(Password password) {
		Status status = new Status();
		Status validatePassword = validatePassword(password);

		if (validatePassword != null && validatePassword.getCode().equals("ERROR")) {
			return validatePassword;
		}

		Optional<User> findBypassword = userServiceRepository.findBypassword(password.getExistingPassword());
		if (findBypassword.isPresent() && !findBypassword.get().getPassword().equals(password.getNewPassword())) {
			userServiceRepository.changePassword(password.getExistingPassword(), password.getNewPassword());
		}
		return status;
	}

	private Status validatePassword(Password password) {
		Status status = new Status();
		if (password != null) {
			if (!password.getNewPassword().equals(password.getRepetPassword())) {
				status.setMessage("New Password and Repet password is not same");
				status.setCode("ERROR");
				return status;
			}
			if (!(password.getNewPassword().length() < 5)) {
				status.setMessage("Password Length must be 5 character");
				status.setCode("ERROR");
				return status;
			}
		}
		return null;
	}

}
