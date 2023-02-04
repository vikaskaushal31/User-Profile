package com.springboot.userapp.userprofile.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.userapp.userprofile.repository.UserRepository;
import com.springboot.userapp.userprofile.user.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailSenderService service;

	public String getOtp(String emailId) throws Exception {

		LocalDateTime now = LocalDateTime.now();
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		User user = userRepository.findByEmailId(emailId);
		if (user == null) {
			throw new Exception("User Not Registered");
		}
		user.setOtp(otp);
		user.setExpierTime(now);
		userRepository.save(user);
		String body = "OTP = " + otp;
		service.sendSimpleEmail(emailId, body);
		return "OTP generated and sent via mail";
	}

	public String validateOtp(int otp, String emailId) {
		
		
		LocalDateTime then = LocalDateTime.now();
		User user = userRepository.findByEmailId(emailId);
		
		long noOfSeconds = (user.getExpierTime()).until(then, ChronoUnit.SECONDS);
		if(noOfSeconds > 30) {
			return "otp expired";
		}
		return otp == user.getOtp() ? "OTP Matched" : "Please Enter Correct OTP";
	}

	public User createUser(User user) throws Exception {
		User checkUserExist = userRepository.findByEmailId(user.getEmailId());
		if (checkUserExist != null) {
			throw new Exception("EmailId is Already Registered");
		}
		return userRepository.save(user);
	}

}
