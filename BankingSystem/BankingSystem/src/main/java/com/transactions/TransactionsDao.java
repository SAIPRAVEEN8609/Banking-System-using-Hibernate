package com.transactions;

import java.util.List;

public interface TransactionsDao {
	public void deposit(long accountNumber,long amount);
	public void withdraw(long accountNumber,long amount);
	List<Transactions> getAccountTransactions(long accountNumber);
}
