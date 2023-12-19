package com.test.dto;


public class UserRegisterDto {

	private String name;

	private String username;
	
	private String email; 

	private String phoneno;
	
	private String password;

	public UserRegisterDto() {
	}

	public UserRegisterDto(String name, String username, String email, String phoneno, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
