package com.sevya.tasks.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends BaseModel {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long mobile;
	private String activeToken;
	private String address;
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getActiveToken() {
		return activeToken;
	}
	public void setActiveToken(String activeToken) {
		this.activeToken = activeToken;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
