package com.capgemini.onlinewallet.dto;

public class WalletUser {
	Integer userID;
	String userName;
	String password;
	String phoneNumber;
	String loginName;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public WalletUser(Integer userID, String userName, String password, String phoneNumber, String loginName) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.loginName = loginName;
	}
	public WalletUser() {
		// TODO Auto-generated constructor stub
	}


}
