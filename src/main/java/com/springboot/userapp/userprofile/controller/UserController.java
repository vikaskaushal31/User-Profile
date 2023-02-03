package com.springboot.userapp.userprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.userapp.userprofile.service.UserService;
import com.springboot.userapp.userprofile.user.User;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String home() {
		return "home";
	}

	@GetMapping("/generateotp")
	@ResponseBody
	public String getOtp(@RequestParam String emailId) throws Exception {
		return userService.getOtp(emailId);
	}

	@GetMapping("/validateotp")
	@ResponseBody
	public String validateotp(@RequestParam("emailId") String emailId, @RequestParam("otp") int otp) {
		return userService.validateOtp(otp, emailId);
	}

	@PostMapping("/createuser")
	@ResponseBody
	public User createUser(@RequestBody User user) throws Exception {
		return userService.createUser(user);
	}

}
