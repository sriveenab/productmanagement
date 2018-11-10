package com.sevya.tasks.security.jwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sevya.tasks.dto.AppBaseDto;

@JsonInclude(Include.NON_NULL)
public class JwtAuthenticatedUserDto extends AppBaseDto {

	private String email;
	private Integer userId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
