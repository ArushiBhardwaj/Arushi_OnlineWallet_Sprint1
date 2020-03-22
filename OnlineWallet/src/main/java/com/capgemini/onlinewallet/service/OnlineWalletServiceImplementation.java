package com.capgemini.onlinewallet.service;
import java.time.LocalDateTime;
import java.util.regex.*;

import java.util.List;
import java.util.Random;

import com.capgemini.onlinewallet.dao.OnlineWalletDao;
import com.capgemini.onlinewallet.dao.OnlineWalletDaoImplementation;
import com.capgemini.onlinewallet.dto.WalletAccount;
import com.capgemini.onlinewallet.dto.WalletTransaction;
import com.capgemini.onlinewallet.dto.WalletUser;
import com.capgemini.onlinewallet.exception.InvalidNameException;
import com.capgemini.onlinewallet.exception.InvalidPasswordException;
import com.capgemini.onlinewallet.exception.InvalidPhoneNumberException;
import com.capgemini.onlinewallet.exception.NegativeBalanceException;
import com.capgemini.onlinewallet.exception.NullException;
import com.capgemini.onlinewallet.exception.ValidationException;

public class OnlineWalletServiceImplementation implements OnlineWalletService {
	OnlineWalletDao onlineWalletDaoObject;
	public OnlineWalletServiceImplementation() {
		onlineWalletDaoObject=new OnlineWalletDaoImplementation();
		
	}
	public Integer registerUser(String userName, String password, String phoneNumber, String loginName,Double accountBalance) {
		Random random=new Random();
		Integer userId=new Integer(random.nextInt(100));
		Integer accountId=new Integer(random.nextInt(1000));
		WalletUser walletUser=new WalletUser(userId,userName,password,phoneNumber,loginName);
		WalletAccount walletAccount=new WalletAccount(accountId,accountBalance,null);
		onlineWalletDaoObject.addEntry(userId, walletUser);
		onlineWalletDaoObject.addEntry(accountId,walletAccount);
		onlineWalletDaoObject.addEntry(userId, accountId);
		return userId;
	}
	public boolean checkName(String userName) throws NullException,InvalidNameException
	{
		if(userName==null) 
			throw new NullException("Entered value cannot be NULL");
		boolean userNamePattern=Pattern.matches("[a-zA-Z]{5,9}",userName);
		 if(userNamePattern==false)
			throw new InvalidNameException("Entered value should contain alphabets only");
		else return true;
		

		
	}
	
	public boolean checkPhoneNumber(String phoneNumber) throws ValidationException,NullException,InvalidPhoneNumberException
	{
		
		if(phoneNumber==null)
			throw new NullException("Entered value cannot be NULL");
		else if(phoneNumber.length()!=10)
			throw new ValidationException("The Number entered must be of in correct format i.e 10 digits");
		boolean phoneNumberPattern=Pattern.matches("[a-zA-z0-9]{10}",phoneNumber);
		 if(phoneNumberPattern==false) 
			throw new InvalidPhoneNumberException("The phone number should be in digits only");
		else return true;
	}
	public boolean checkPassword(String password) throws ValidationException,NullException,InvalidPasswordException
	{
		if(password==null)
			throw new NullException("Entered value cannot be NULL");
		else if(password.length()<6)
			throw new ValidationException("The PassWord entered must be greater or equal to 6 characters");
		boolean passwordPattern=Pattern.matches("[a-zA-z0-9$&+,:;=?@#|'<>.-^*()%!]",password);
		if(passwordPattern==false)
			throw new InvalidPasswordException("Entered value should be alphanumeric and must contain special characters");
		else return true;
	}
	public Double addMoney(Integer userId,Double amount) {
		// TODO Auto-generated method stub
		Double balance=onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
		WalletTransaction transaction=createTransaction("The amount was added succesfully into account",amount,balance);
		onlineWalletDaoObject.addEntry(transaction.getTransactionID(), transaction);
//		updateEntry(userId,transaction.getTransactionID());
		return addBalance(userId,amount);

	}
	public Double showBalance(Integer userId) {
		// TODO Auto-generated method stub
        return onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
	}
    
    public boolean checkId(Integer userId) throws NullException
    {
    	if(onlineWalletDaoObject.fetchUser(userId)==null)
    		throw new NullException("The user doesn't exist. Enter a valid userId");
    	else return true;
    }
    public boolean checkBalance(Integer userId,double amount) throws NegativeBalanceException
    {
    	double balance=onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
    	if(amount>balance)
    		throw new NegativeBalanceException("Insufficient funds in account balance, please enter valid amount");
    	else if(amount==balance)
    		throw new NegativeBalanceException("The balance cannot become 0 after transaction");
    	else return true;
    }
    public double addBalance(Integer userId,double amount)
    {
    double accountBalance=onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
    accountBalance+=amount;
    onlineWalletDaoObject.fetchAccount(userId).setAccountBalance(accountBalance);
    Integer accountId=onlineWalletDaoObject.fetchAccount(userId).getAccountID();
    onlineWalletDaoObject.updateEntry(accountId, onlineWalletDaoObject.fetchAccount(userId));
    return onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
    }
    public double deductBalance(Integer userId,double amount)
    {
    	double accountBalance=onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
    	accountBalance-=amount;
    	onlineWalletDaoObject.fetchAccount(userId).setAccountBalance(accountBalance);
    	Integer accountId=onlineWalletDaoObject.fetchAccount(userId).getAccountID();
    	onlineWalletDaoObject.updateEntry(accountId, onlineWalletDaoObject.fetchAccount(userId));
    	return onlineWalletDaoObject.fetchAccount(userId).getAccountBalance();
    }
    public WalletTransaction createTransaction(String description,Double amount,Double accountBalance)
    {
    	 Random random= new Random();
 	    Integer transactionId=new Integer(random.nextInt(10000));
 	    WalletTransaction transaction= new WalletTransaction(transactionId,description,LocalDateTime.now(),amount,accountBalance);
 	    
 		return transaction;
    }
    public void updateEntry(Integer userId, Integer userTransactionId)
	{
		WalletAccount userAccount=onlineWalletDaoObject.fetchAccount(userId);
        List<Integer> transactionList=userAccount.getTransactionHistory();
        transactionList.add(userTransactionId);
        userAccount.setTransactionHistory(transactionList);
        onlineWalletDaoObject.updateEntry(userAccount.getAccountID(),userAccount);
	}
    
    public void transactMoney(Integer userId,Integer transferUserId,double amount) throws NullException,NegativeBalanceException {
    	checkId(transferUserId);
        checkBalance(userId,amount);
        Double userBalance=addBalance(transferUserId,amount);
        Double transactBalance=deductBalance(userId,amount);
        
        WalletTransaction userTransaction=createTransaction("the Amount was tranfered to another account successfully",amount,userBalance);
        WalletTransaction transactTransaction=createTransaction("the Amount was recived from another account successfully",amount,transactBalance);
        
        Integer userTransactionId=userTransaction.getTransactionID();
        Integer transactTransactionId=transactTransaction.getTransactionID();
        
        updateEntry(userId,userTransactionId);
        updateEntry(transferUserId,transactTransactionId);
        
        onlineWalletDaoObject.addEntry(userTransactionId, userTransaction);
        onlineWalletDaoObject.addEntry(transactTransactionId, transactTransaction);
    }
 	
}


