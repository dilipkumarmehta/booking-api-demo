package com.booking.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.beans.User;

@RestController

public class UserServiceController {

	@RequestMapping(value = "/launching", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public String launching() {
		String launchingResponsc = "this responce from launching page";
		return launchingResponsc;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public String login(@RequestBody User user) {
		String loginResponsc = "this responce from login page";
		return loginResponsc;

	}

	@RequestMapping(value = "/userdetails", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public String userDetails() {
		String userdetailsResponsc = "this responce from login page";
		return userdetailsResponsc;

	}

}
