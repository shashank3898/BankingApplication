package com.tcs.bank_app.dto;

import jakarta.validation.constraints.NotBlank;

public class CustomerDTO {
	
	@NotBlank
	private String customerName;
	@NotBlank
	private String customerPassword;
	@NotBlank
	private String customeremail;
	//@NotBlank
	private int customerPhoneNo;
	@NotBlank
	private String customerAddress;
	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	public int getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	public void setCustomerPhoneNo(int customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
}
