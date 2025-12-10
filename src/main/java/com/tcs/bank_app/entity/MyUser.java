package com.tcs.bank_app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class MyUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@NotBlank
	@NotNull
	private String userName;
	@NotBlank
	@NotNull
	private String userPassword;
	private String userRole="ROLE_USER";
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private MyCustomer customer;
	
	public MyUser() {
		super();
	}

	public MyUser(long userId, @NotBlank @NotNull String userName, @NotBlank @NotNull String userPassword,
			String userRole, MyCustomer customer) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.customer = customer;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public MyCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(MyCustomer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "MyUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userRole="
				+ userRole + ", customer=" + customer + "]";
	}
	
}
