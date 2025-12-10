package com.tcs.bank_app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="customers")
public class MyCustomer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	@NotBlank
	@NotNull
	private String customerName;
	@NotBlank
	@NotNull
	private String customerEmail;
	//@NotBlank
	//@NotNull
	private int customerPhoneNo;
	@NotBlank
	@NotNull
	private String customerAddress;
	@OneToOne
	@JoinColumn(name = "user_id")
	private MyUser user;
	@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<BankAccount> account=new ArrayList<>();
	
	public MyCustomer() {
		super();
	}

	public MyCustomer(long customerId, @NotBlank @NotNull String customerName, @NotBlank @NotNull String customerEmail,
			@NotBlank @NotNull int customerPhoneNo, @NotBlank @NotNull String customerAddress, MyUser user,
			List<BankAccount> account) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhoneNo = customerPhoneNo;
		this.customerAddress = customerAddress;
		this.user = user;
		this.account = account;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public List<BankAccount> getAccount() {
		return account;
	}

	public void setAccount(List<BankAccount> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "MyCustomer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPhoneNo=" + customerPhoneNo + ", customerAddress=" + customerAddress
				+ ", user=" + user + ", account=" + account + "]";
	}
	
}
