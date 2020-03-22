package com.capgemini.onlinewallet.dao;

import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.dto.WalletTransaction;
import com.capgemini.onlinewallet.dto.WalletUser;

public interface OnlineWalletDao {
	void addEntry(Integer userId,WalletUser user);
	void addEntry(Integer accountId, WalletAccount account);
	void addEntry(Integer transactionId,WalletTransaction transaction);
	void addEntry(Integer userId,Integer accountId);
	WalletUser fetchUser(Integer userId);
	WalletAccount fetchAccount(Integer userId);
	WalletTransaction fetchTransaction(Integer transactionId);
	void updateEntry(Integer userId, WalletUser user);
	void updateEntry(Integer accountId,WalletAccount account);
	void updateEntry(Integer transactionId,WalletTransaction transaction);
	void updateEntry(Integer userId,Integer accountId);

}
