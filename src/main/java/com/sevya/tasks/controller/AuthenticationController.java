package com.sevya.tasks.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sevya.tasks.dto.AuthenticatedUserDto;
import com.sevya.tasks.dto.LoginCredentialsDto;
import com.sevya.tasks.model.User;
import com.sevya.tasks.security.jwt.JwtAuthenticatedUserDto;
import com.sevya.tasks.security.jwt.JwtService;
import com.sevya.tasks.service.UserService;

@RestController
public class AuthenticationController {

	@Autowired
	public UserService userService;
	
	@Autowired
	public JwtService jwtService;
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public AuthenticatedUserDto authenticateToken(@RequestBody LoginCredentialsDto loginCredentialsDto) throws IOException, URISyntaxException {
		AuthenticatedUserDto authenticatedUserDto = new AuthenticatedUserDto();
		User user = userService.getUserByEmail(loginCredentialsDto.getEmail());
		if(user != null) {
			JwtAuthenticatedUserDto jwtAuthenticatedUserDto = new JwtAuthenticatedUserDto();
			jwtAuthenticatedUserDto.setEmail(loginCredentialsDto.getEmail());
			jwtAuthenticatedUserDto.setUserId(user.getId());
			jwtAuthenticatedUserDto.setTimeZone(loginCredentialsDto.getTimeZone());
			String token = jwtService.tokenFor(jwtAuthenticatedUserDto);
			authenticatedUserDto.setToken(token);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String langDate = sdf.format(user.getCreatedDate());
			authenticatedUserDto.setCreatedDate(langDate);
			authenticatedUserDto.setEmail(user.getEmail());
			authenticatedUserDto.setFirstName(user.getFirstName());
			authenticatedUserDto.setLastName(user.getLastName());
		}
		return authenticatedUserDto;
	}
	
}
