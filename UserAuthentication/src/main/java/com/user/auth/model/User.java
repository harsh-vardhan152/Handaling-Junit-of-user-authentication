package com.user.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Auth")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	@Column(name="user_name")
	private String username;
	@Column(name="user_email")
	private String email;
	@Column(name="user_password")
	private String password;
	@Column (name="rest_password_token")
	private String resetPasswordToken;
	
	public User(int id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User(int id, String username, String email, String password, String resetPasswordToken) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.resetPasswordToken = resetPasswordToken;
	}


	public String getResetPasswordToken() {
		return resetPasswordToken;
	}


	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", resetPasswordToken=" + resetPasswordToken + "]";
	}
	
	
	
	
}
