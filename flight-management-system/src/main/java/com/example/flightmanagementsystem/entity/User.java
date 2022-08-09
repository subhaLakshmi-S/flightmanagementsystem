
package com.example.flightmanagementsystem.entity;

import java.math.BigInteger;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "users")
public class User {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String userId;
	@Column
	//@NotNull
	//@NotBlank(message="Please enter a phone number")
	//@Size(min=10,max=10,message="Invalid Phone Number")
	private String phoneNo;
	@Column
	//@Email(message="invalid Email id")
	//@NotBlank(message="Email cannot be blank")
	private String userEmail;
	@Column
	//@NotNull
	//@NotBlank(message="Please enter a name")
	private String userName;
	@Column
	//@NotNull
	//@NotBlank(message="Please enter usertype")
	private String userType;
	@Column
	//@NotNull
	//@NotBlank(message="Please enter a password")
	private String password;

public  String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 public String getUserId() { return userId; } 
	 
	public void setUserId(String userId) { 
  this.userId = userId; 
  }
	@Override
	public String toString() {
		return "User [userId=" + userId + ", phoneNo=" + phoneNo + ", userEmail=" + userEmail + ", userName=" + userName
				+ ", userType=" + userType + ", password=" + password + "]";
	}
	 
	
	
}

