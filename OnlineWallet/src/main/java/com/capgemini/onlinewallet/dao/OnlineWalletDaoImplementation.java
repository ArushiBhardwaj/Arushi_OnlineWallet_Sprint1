package com.capgemini.onlinewallet.dao;

import java.util.HashMap;

import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.dto.WalletTransaction;
import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.util.Repositories;

public class OnlineWalletDaoImplementation implements OnlineWalletDao {
	Repositories repository;
	private static HashMap<Integer,WalletUser> walletUser;
	private static HashMap<Integer,WalletTransaction> walletTransaction;
	private static HashMap<Integer,WalletAccount> walletAccount;
	 private static HashMap<Integer,Integer> userAccount;
	 
	public OnlineWalletDaoImplementation() {
		super();
		repository=new Repositories();
		walletAccount=Repositories.getWalletAccountTable();
		walletUser=repository.getWalletUserTable();
		walletTransaction=repository.getWalletTransactionsTable();
		userAccount=repository.getUserAccountTable();
		
	}
	public void addEntry(Integer userId,WalletUser user) {
		
		walletUser.put(userId, user);
		repository.setWalletUserTable(walletUser);
		
	}
	public void addEntry(Integer accountId, WalletAccount account) {
		
		walletAccount.put(accountId, account);
		repository.setWalletAccountTable(walletAccount);
	}
	public void addEntry(Integer transactionId, WalletTransaction transaction) {
		
		walletTransaction.put(transactionId, transaction);
		repository.setWalletTransactionsTable(walletTransaction);
	}
	public void addEntry(Integer userId,Integer accountId) {
		
		userAccount.put(userId, accountId);
		repository.setUserAccountTable(userAccount);
	}
	public WalletUser fetchUser(Integer userId) {
		return walletUser.get(userId);
	}
	public WalletAccount fetchAccount(Integer userId) {
		return walletAccount.get(userId);
	}
	public WalletTransaction fetchTransaction(Integer transactionId) {
		return walletTransaction.get(transactionId);
	}
	public void updateEntry(Integer userId,WalletUser user) {
		walletUser.replace(userId,user);
	}
	public void updateEntry(Integer accountId,WalletAccount account) {
		walletAccount.replace(accountId, account);
	}
	public void updateEntry(Integer transactionId,WalletTransaction transaction) {
		walletTransaction.replace(transactionId, transaction);
	}
    public void updateEntry(Integer userId,Integer accountId) {
    	userAccount.replace(userId,accountId);
    }
}
