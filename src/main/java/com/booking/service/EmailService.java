package com.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

//https://www.google.com/settings/security/lesssecureapps
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String email) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);

		msg.setSubject("Request to reset your password");
		msg.setText("http://localhost:8089/account/reset-password");

		javaMailSender.send(msg);

	}
}