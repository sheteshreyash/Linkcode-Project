package com.test.entity;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.List;


@Entity
@Table(name="loginapp", uniqueConstraints = @UniqueConstraint(columnNames = "Email") )
public class User //implements UserDetails
{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="Name")
	private String name;

	@Column(name = "Username")
	private String username;
	
	@Column(name = "Email")
	private String email; 

	@Column(name = "PhoneNo")
	private String phoneno;
	
	@Column(name = "Password")
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
    private List<Profile> profile=new ArrayList<>();

	public User() {
	}


	public User(Long id, String name, String username, String email, String phoneno, String password,
			List<Profile> profile) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		this.profile = profile;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public List<Profile> getProfile() {
		return profile;
	}


	public void setProfiles(List<Profile> profile) {
		this.profile = profile;
	}
	
}
