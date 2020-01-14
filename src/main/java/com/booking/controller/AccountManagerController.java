package com.booking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.beans.Status;
import com.booking.beans.UserLoginBean;
import com.booking.service.AccountManagerService;

@RestController

@RequestMapping("/account")
public class AccountManagerController {

	@Autowired
	AccountManagerService userService;
	Logger logger = LoggerFactory.getLogger(AccountManagerController.class);

	/*
	 * This method is for existing user to login, it will take user name/email and
	 * validate from database.
	 */
	@RequestMapping(value = "sign-in", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Status signIn(@RequestBody UserLoginBean userLoginBean) {
		Status status = new Status();
		Status logIn = userService.logIn(userLoginBean);
		return logIn;

	}

	// Verify the email id in DB ,it is available or not
	@RequestMapping(value = "verify-email", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Status verifyUserEmail(@RequestBody UserLoginBean loginRequest) {
		Status status = new Status();
		UserLoginBean loginResponsc = userService.verifyLoginEmail(loginRequest);
		if (loginResponsc == null) {
			status.setSuccess_message("There is no account associated with this email address");
			status.setSuccess_code("400");
			return status;
		}
		status.setSuccess_message("You already have a account registered to this email address");
		status.setSuccess_code("403");
		return status;

	}

	// register with emai land pasword
	@RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Status registerUser(@RequestBody UserLoginBean loginRequest) {
		Status status = new Status();

		UserLoginBean loginResponsc = userService.verifyLoginEmail(loginRequest);
		if (loginResponsc != null) {
			status.setError_message("You already have a account registered to this email go for login");
			status.setError_code("403");
			return status;
		}
		UserLoginBean registerUser = userService.registerUser(loginRequest);
		if (registerUser != null) {
			status.setSuccess_message("You have successfully registered with email" + loginRequest.getEmailId());
			status.setSuccess_code("200");
			return status;
		}
		status.setSuccess_message("Erro occured while creating account please try again");
		status.setSuccess_code("500");
		return status;
	}

	// send the link to update password
	@RequestMapping(value = "account-recovery", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Status accountRecovery(@RequestBody UserLoginBean userLoginBean) {
		userService.sendEmailToResetPassword(userLoginBean.getEmailId());
		return null;
	}

	// update password
	@RequestMapping(value = "reset-password", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Status resetPassword(@RequestBody UserLoginBean userLoginBean) {

		return null;
	}

	// Click the link to conform password and redirect to login url
	@RequestMapping(value = "emai-confirmation", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Status emailConfirmation(@RequestBody UserLoginBean userLoginBean) {

		return null;
	}

	/*
	 * @RequestMapping(value = "sign-in/password", method = RequestMethod.POST,
	 * produces = "application/json", consumes = "application/json") public Status
	 * loginByUserPassword(@RequestBody LoginRequestBean user) { Status
	 * loginResponsc = userService.verifyLoginEmail(user); return loginResponsc;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "register/login_name", method = RequestMethod.POST,
	 * produces = "application/json", consumes = "application/json") public Status
	 * registerLoginByname(@RequestBody LoginRequestBean user) { Status
	 * loginResponsc = userService.verifyLoginEmail(user); return loginResponsc;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "email_verification/login-email", method =
	 * RequestMethod.POST, produces = "application/json", consumes =
	 * "application/json") public Status emailVerification(@RequestBody
	 * LoginRequestBean user) { Status loginResponsc =
	 * userService.verifyLoginEmail(user); return loginResponsc;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "register/password", method = RequestMethod.POST,
	 * produces = "application/json", consumes = "application/json") public Status
	 * registerLoginPassword(@RequestBody LoginRequestBean user) { Status
	 * loginResponsc = userService.verifyLoginEmail(user); return loginResponsc;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "account-recovery/login_name", method =
	 * RequestMethod.POST, produces = "application/json", consumes =
	 * "application/json") public Status accountRecovery(@RequestBody
	 * LoginRequestBean user) { Status loginResponsc =
	 * userService.verifyLoginEmail(user); return loginResponsc; }
	 * 
	 * @RequestMapping(value = "reset-password/login_name", method =
	 * RequestMethod.POST, produces = "application/json", consumes =
	 * "application/json") public Status resetPassword(@RequestBody LoginRequestBean
	 * user) { Status loginResponsc = userService.verifyLoginEmail(user); return
	 * loginResponsc; }
	 */

	/*
	 * @RequestMapping(value = "/logout/{userId}", method = RequestMethod.POST,
	 * produces = "application/json", consumes = "application/json") public Status
	 * logOut(@PathVariable(value = "userid") String userId) { return null;
	 * 
	 * }
	 */
	/*
	 * @RequestMapping(value = "/signup", method = RequestMethod.POST, produces =
	 * "application/json", consumes = "application/json") public Status
	 * signUp(@RequestBody User user) { Status signupResponse =
	 * userService.signUp(user); return signupResponse;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/changepassword", method = RequestMethod.POST,
	 * produces = "application/json", consumes = "application/json") public Status
	 * changePassword(@RequestBody Password password) { return
	 * userService.changepasswor(password);
	 * 
	 * }
	 */

	// @RequestMapping(value="/pow", method=RequestMethod.GET)
	// (@RequestParam(value="base") int base1)

	// @RequestMapping("/sqrt/{num}")
	// public double sqrt(@PathVariable(value="num") int num1)

}
