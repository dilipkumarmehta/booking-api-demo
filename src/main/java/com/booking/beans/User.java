package com.booking.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail1")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "mobileNmber")
	private long mobileNmber;
	
	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "firstName")
	private String firstName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getMobileNmber() {
		return mobileNmber;
	}

	public void setMobileNmber(long mobileNmber) {
		this.mobileNmber = mobileNmber;
	}

}
