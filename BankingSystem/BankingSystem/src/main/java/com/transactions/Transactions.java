package com.transactions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.User.Accounts;

@Entity
@Table(name="Transactions")
public class Transactions {
	@Id
	private long transactionNumber;
	private long accountNumber;
	private String transactionType;
	private long transactionsAmmount;
	private String dateTime;
	private long Balance;
	
	
	
	public Transactions() {
		
	}

	

	public Transactions(long transactionNumber, long accountNumber, String transactionType, long transactionsAmmount,
			String dateTime, long balance) {
		super();
		this.transactionNumber = transactionNumber;
		this.accountNumber = accountNumber;
		this.transactionType = transactionType;
		this.transactionsAmmount = transactionsAmmount;
		this.dateTime = dateTime;
		Balance = balance;
	}



	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public long getTransactionsAmmount() {
		return transactionsAmmount;
	}

	public void setTransactionsAmmount(long transactionsAmmount) {
		this.transactionsAmmount = transactionsAmmount;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public long getBalance() {
		return Balance;
	}

	public void setBalance(long balance) {
		Balance = balance;
	}

	@Override
	public String toString() {
		return "Transactions [transactionNumber=" + transactionNumber + ", transactionType=" + transactionType
				+ ", transactionsAmmount=" + transactionsAmmount + ", dateTime=" + dateTime + ", Balance=" + Balance
				+ "]";
	}
	
	
}
