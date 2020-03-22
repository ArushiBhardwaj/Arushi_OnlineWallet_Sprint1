package com.capgemini.onlinewallet.dto;
import java.time.LocalDateTime;
public class WalletTransaction {
	Integer transactionID;
	String description;
	LocalDateTime dateOfTransaction;
	Double amount;
	Double accountBalance;
	public Integer getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(Integer transactionID) {
		this.transactionID = transactionID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public WalletTransaction(Integer transactionID, String description, LocalDateTime dateOfTransaction, Double amount,
			Double accountBalance) {
		super();
		this.transactionID = transactionID;
		this.description = description;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
		this.accountBalance = accountBalance;
	}
	public WalletTransaction() {
		// TODO Auto-generated constructor stub
	}

}
