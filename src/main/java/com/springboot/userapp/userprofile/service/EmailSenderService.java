package com.springboot.userapp.userprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(String toEmail, String body) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("vikaskaushal31@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject("OTP From User API");

		mailSender.send(message);
	}

}
