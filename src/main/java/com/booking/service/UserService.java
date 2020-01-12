package com.booking.service;

import com.booking.beans.Password;
import com.booking.beans.Status;
import com.booking.beans.User;

public interface UserService {
	public Status signUp(User user);

	public Status logIn(User user);

	public Status logOut(String userId);

	public Status changepasswor(Password password);

}