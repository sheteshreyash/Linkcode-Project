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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;


@Entity
@Table(name="loginapp", uniqueConstraints = @UniqueConstraint(columnNames = "Email") )
public class User //implements UserDetails
{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Name cannot be null")
	@Size(min = 3, max = 30, message = "Name should have minimum 2 and maximum 30 characters")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Name should contain only alphabets")
	@Column(name ="Name")
	private String name;

	@NotBlank(message = "Username is required!")
	@Pattern(regexp = "^[^\\s]+$", message = "Username must not contain spaces")
	@Column(name = "Username")
	private String username;
	
	
	@NotBlank(message = "Email is required!")
    @Email(message = "Please enter a valid email address!")
	@Column(name = "Email")
	private String email; 


	@NotBlank(message = "Phone number is required!")
	@Size(min = 10, max = 10, message = "Please enter a 10-digit phone number!")
	@Pattern(regexp="^[0-9]*$", message="Phone number must be numeric")
	@Column(name = "PhoneNo")
	private String phoneno;
	
	
	@NotBlank(message = "Password is required!")
	@Size(min = 8, message = "Password must be at least 8 characters long!")
	@Pattern(regexp="^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[a-z]).{8,}$", message="Password must contain at least 8 characters including one uppercase letter, one symbol, and one lowercase letter.")
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
