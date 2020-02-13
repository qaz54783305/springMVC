package com.tibame.domain;

public class Address implements java.io.Serializable{
	private short addressId;
	private String address1;
	private String address2;
	private String postCode;
	public short getAddressId() {
		return addressId;
	}
	public void setAddressId(short addressId) {
		this.addressId = addressId;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
}
