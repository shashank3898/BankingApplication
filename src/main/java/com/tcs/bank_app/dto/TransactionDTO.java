package com.tcs.bank_app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class TransactionDTO {
	
	@NotNull
	private long accountId;
	@PositiveOrZero
	private double amount;
	@NotNull
	private long targetAccountId;
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getTargetAccountId() {
		return targetAccountId;
	}
	public void setTargetAccountId(long targetAccountId) {
		this.targetAccountId = targetAccountId;
	}
	
}
