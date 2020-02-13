package com.tibame.domain;
//JavaBean 
public class Customer {
	private short customerID;
	private String firstName;
	private String lastName;
	private String email;
	public short getCustomerID() {
		return customerID;
	}
	public void setCustomerID(short customerID) {
		this.customerID = customerID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
