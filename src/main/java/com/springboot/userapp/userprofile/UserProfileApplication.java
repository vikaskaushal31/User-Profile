package com.springboot.userapp.userprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class UserProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileApplication.class, args);
	}
}
