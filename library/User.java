package com.qac.library;

public class User {

	private int userID;

	private String userName;
	private String userAddress;
	private int userPhoneNumber;

	public User(int userID, String userName, String userAddress, int userPhoneNumber) {
		this.userID = userID;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userPhoneNumber = userPhoneNumber;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(int userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
}
