package com.capgemini.onlinewallet.ui;
import java.util.Scanner;

import com.capgemini.onlinewallet.service.*;
public class OnlineWalletUi {
    static OnlineWalletService onlineWalletServiceObject;
    static Scanner scanner;
    static Integer userId;
    
	public OnlineWalletUi() {
		// TODO Auto-generated constructor stub
		onlineWalletServiceObject=new OnlineWalletServiceImplementation();
		scanner=new Scanner(System.in);
	}
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OnlineWalletUi();
		System.out.println("Enter choice to continue");
		System.out.println("1: To register as a new user");
		System.out.println("2: Login if already registered");
		try {
			int choice=scanner.nextInt();
		switch(choice)
		{
		case 1: System.out.println("Enter UserName, password, phoneNumber, loginName ");
				String userName=scanner.next();
				String password=scanner.next();
				String phoneNumber=scanner.next();
				String loginName=scanner.next();
				System.out.println("Please enter initial amount to be deposited into your account");
				Double amount=scanner.nextDouble();
				userId=onlineWalletServiceObject.registerUser(userName,password,phoneNumber,loginName,amount);
				System.out.println("Your User ID is: " + userId + " \nkeep a record of this");
				break;
		case 2: break;
		default :return;
		}}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
			System.exit(0);
		}
        while(true)
        {   try {
        	System.out.println("Enter the choice");
        	System.out.println("1: Add Money");
        	System.out.println("2: Show Balance");
        	System.out.println("3: Transact Money");
        	Double balance;
        	int choice=scanner.nextInt();
        	switch(choice)
        	{
        	case 1: System.out.println("Enter amount to add");
        			balance=scanner.nextDouble();
        			onlineWalletServiceObject.addMoney(userId, balance);
        	        System.out.println("The money was added succesfully \nthe amount added is: " + balance);
        	        break;
        	case 2: balance=onlineWalletServiceObject.showBalance(userId);
        	        System.out.println("The balance is: " + balance);
        			break;
        	case 3: System.out.println("Enter ID of user you want to transact the money to");
        			Integer transactId=scanner.nextInt();
        			System.out.println("Enter amount to transact: ensure enough balance");
        			Double amount=scanner.nextDouble();
        			onlineWalletServiceObject.transactMoney(userId, transactId, amount);
        			break;
        	default: System.out.println("Wrong choice!!");
        	         return;
        	}}
        catch(Exception ex)
        {
        	System.out.println(ex.getMessage());
        }
        }
		
	}

}

