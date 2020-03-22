package com.capgemini.onlinewallet.service;

import com.capgemini.onlinewallet.exception.NegativeBalanceException;
import com.capgemini.onlinewallet.exception.NullException;

public interface OnlineWalletService {
	Integer registerUser(String userName, String password, String phoneNumber, String loginName,Double accountBalance);
	Double addMoney(Integer userId,Double amount);
	Double showBalance(Integer userId);
	void transactMoney(Integer userId,Integer transferUserId,double amount) throws NullException,NegativeBalanceException;

}
