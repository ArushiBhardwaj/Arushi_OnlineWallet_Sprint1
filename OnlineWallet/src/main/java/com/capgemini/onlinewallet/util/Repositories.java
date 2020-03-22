package com.capgemini.onlinewallet.util;
import com.capgemini.onlinewallet.dto.*;
import java.util.HashMap;
public class Repositories {
	private static HashMap<Integer,WalletUser> walletUserTable=new HashMap<Integer,WalletUser>();
	private static HashMap<Integer,WalletTransaction> walletTransactionTable=new HashMap<Integer,WalletTransaction>();
	private static HashMap<Integer,WalletAccount> walletAccountTable=new HashMap<Integer,WalletAccount>();
	 private static HashMap<Integer,Integer> userAccountTable=new HashMap<Integer,Integer>();
	public static HashMap<Integer, WalletUser> getWalletUserTable() {
		return walletUserTable;
	}
	public static void setWalletUserTable(HashMap<Integer, WalletUser> walletUserTable) {
		Repositories.walletUserTable = walletUserTable;
	}
	public static HashMap<Integer, WalletTransaction> getWalletTransactionsTable() {
		return walletTransactionTable;
	}
	public static void setWalletTransactionsTable(HashMap<Integer, WalletTransaction> walletTransactionsTable) {
		Repositories.walletTransactionTable = walletTransactionsTable;
	}
	public static HashMap<Integer, WalletAccount> getWalletAccountTable() {
		return walletAccountTable;
	}
	public static void setWalletAccountTable(HashMap<Integer, WalletAccount> walletAccountTable) {
		Repositories.walletAccountTable = walletAccountTable;
	}
	public static HashMap<Integer, Integer> getUserAccountTable() {
		return userAccountTable;
	}
	public static void setUserAccountTable(HashMap<Integer, Integer> userAccountTable) {
		Repositories.userAccountTable = userAccountTable;
	}
	 
}
