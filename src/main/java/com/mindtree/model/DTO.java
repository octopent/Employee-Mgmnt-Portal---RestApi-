package com.mindtree.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DTO {
	@Id
	private String username;
	private String password;
	
	public DTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
