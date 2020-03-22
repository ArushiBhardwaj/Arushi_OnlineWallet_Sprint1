package com.capgemini.onlinewallet.dto;
import java.util.List;
public class WalletAccount {
	Integer accountID;
	Double accountBalance;
	enum status{active,non_active}
	List<Integer> transactionHistory;
	public Integer getAccountID() {
		return accountID;
	}
	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public List<Integer> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(List<Integer> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	public WalletAccount(Integer accountID, Double accountBalance, List<Integer> transactionHistory) {
		super();
		this.accountID = accountID;
		this.accountBalance = accountBalance;
		this.transactionHistory = transactionHistory;
	}
	public WalletAccount() {
		// TODO Auto-generated constructor stub
	}

}


