package com.booking.service;

import com.booking.beans.Status;
import com.booking.beans.UserLoginBean;

public interface AccountManagerService {

	public UserLoginBean verifyLoginEmail(UserLoginBean loginRequestBean);

	public UserLoginBean registerUser(UserLoginBean loginRequestBean);

	public Status logIn(UserLoginBean user);

	public Status sendEmailToResetPassword(String email);

	/*
	 * public Status logIn(LoginRequestBean user);
	 * 
	 * public Status logOut(String userId);
	 * 
	 * public Status changepasswor(Password password);
	 */

}