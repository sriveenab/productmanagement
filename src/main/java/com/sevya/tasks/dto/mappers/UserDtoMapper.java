package com.sevya.tasks.dto.mappers;

import java.util.Date;

import com.sevya.tasks.dto.UserDetailsDto;
import com.sevya.tasks.model.User;

public class UserDtoMapper {
	
	public static User toUser(UserDetailsDto userDetailsDto) {
		User user = new User();
		user.setEmail(userDetailsDto.getEmail());
		user.setCreatedDate(new Date());
		user.setAddress(userDetailsDto.getAddress());
		user.setFirstName(userDetailsDto.getFirstName());
		user.setLastName(userDetailsDto.getLastName());
		user.setMobile(userDetailsDto.getMobile());
		user.setPassword(userDetailsDto.getPassword());
		return user;
	}
	
}
