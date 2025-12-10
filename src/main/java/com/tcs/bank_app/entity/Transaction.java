package com.tcs.bank_app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name="transactions")
public class Transaction {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	@PositiveOrZero
	private double transactionAmount;
	@NotBlank
	@NotNull
	private String transactionType;
	private LocalDateTime transactionDate = LocalDateTime.now();
	@ManyToOne
	@JoinColumn(name = "bank_account_id")
	private BankAccount account;
	
	public Transaction() {
		super();
	}

	public Transaction(long transactionId, @PositiveOrZero double transactionAmount,
			@NotBlank @NotNull String transactionType, LocalDateTime transactionDate, BankAccount account) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.account = account;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount
				+ ", transactionType=" + transactionType + ", transactionDate=" + transactionDate + ", account="
				+ account + "]";
	}
	
}
