package com.transactions;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class TransactionsMain {
	public  void transaction(SessionFactory factory) {
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Session session =factory.openSession();
			TransactionsDaoImp tran = new TransactionsDaoImp(session);
			
				
				System.out.println("1.Deposit \t2.Withdraw \t3.Transaction Historys");		
				int key= sc.nextInt();
				switch (key) {
				case 1:
					System.out.print("enter the Account Number: ");
					long accountNumber =sc.nextLong();
					System.out.print("Enter the ammount : ");
					long ammount = sc.nextLong();
					tran.deposit(accountNumber, ammount);
					break;
				case 2:
					System.out.print("enter the Account Number: ");
					accountNumber =sc.nextLong();
					System.out.print("Enter the ammount : ");
					ammount = sc.nextLong();
					tran.withdraw(accountNumber, ammount);
					break;
				case 3:
                   
                    System.out.print("Enter the Account Number: ");
                    accountNumber = sc.nextLong();
                   tran.getAccountTransactions(accountNumber);
                    break;
				
				
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
