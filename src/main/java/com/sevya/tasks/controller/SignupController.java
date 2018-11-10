package com.sevya.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sevya.tasks.dto.UserDetailsDto;
import com.sevya.tasks.dto.UserDto;
import com.sevya.tasks.dto.mappers.UserDtoMapper;
import com.sevya.tasks.model.User;
import com.sevya.tasks.service.UserService;

@RestController
public class SignupController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public UserDto signup(@RequestBody UserDetailsDto userDetailsDto) {
		UserDto userDto = new UserDto();
		//userService.saveUser(UserDtoMapper.toUser(userDetailsDto));
		User user = userService.saveUser(UserDtoMapper.toUser(userDetailsDto));
		return userDto;
		
		
	}
	
}
