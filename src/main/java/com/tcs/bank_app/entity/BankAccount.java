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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name="bank_accounts")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bankAccountId;
	@NotBlank
	@NotNull
	private long bankAccountNo;
	@PositiveOrZero
	private double bankAccountBalance=0.0;
	
	private AccountType bankAccountType;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private MyCustomer customer;
	@OneToMany(mappedBy = "account",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Transaction> transaction = new ArrayList<>();
	
	public BankAccount() {
		super();
	}

	public BankAccount(long bankAccountId, @NotBlank @NotNull long bankAccountNo,
			@PositiveOrZero double bankAccountBalance, @NotBlank @NotNull AccountType bankAccountType, MyCustomer customer,
			List<Transaction> transaction) {
		super();
		this.bankAccountId = bankAccountId;
		this.bankAccountNo = bankAccountNo;
		this.bankAccountBalance = bankAccountBalance;
		this.bankAccountType = bankAccountType;
		this.customer = customer;
		this.transaction = transaction;
	}

	public long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public long getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(long bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public double getBankAccountBalance() {
		return bankAccountBalance;
	}

	public void setBankAccountBalance(double bankAccountBalance) {
		this.bankAccountBalance = bankAccountBalance;
	}

	public AccountType getBankAccountType() {
		return bankAccountType;
	}

	public void setBankAccountType(AccountType bankAccountType) {
		this.bankAccountType = bankAccountType;
	}

	public MyCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(MyCustomer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "BankAccount [bankAccountId=" + bankAccountId + ", bankAccountNo=" + bankAccountNo
				+ ", bankAccountBalance=" + bankAccountBalance + ", bankAccountType=" + bankAccountType + ", customer="
				+ customer + ", transaction=" + transaction + "]";
	}
	
}
