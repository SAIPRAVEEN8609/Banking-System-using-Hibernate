package com.transactions;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.User.Accounts;

import resources.DateTime;
import resources.RandomNumberGenerator;

public class TransactionsDaoImp implements TransactionsDao {
    private Session session;
    
    public TransactionsDaoImp(Session session) {
        super();
        this.session = session;
    }
    DateTime dt = new DateTime();
    RandomNumberGenerator num = new RandomNumberGenerator();
    @Override
    public void deposit(long accountNumber, long amount) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Accounts account = session.createQuery("FROM Accounts WHERE accountNumber = :accountNumber", Accounts.class)
                    .setParameter("accountNumber", accountNumber)
                    .getSingleResult();          
            if (account != null) {
            	if(account.getAccountStatus().equals("Active")) {
            		 account.setAccountBalance(account.getAccountBalance() + amount);
                     session.update(account);

                     Transactions transaction = new Transactions();
                     transaction.setTransactionNumber(num.generateRandom10DigitNumber());
                     transaction.setTransactionType("Deposit");
                     transaction.setTransactionsAmmount(amount);
                     transaction.setDateTime(LocalDateTime.now().toString()); 
                     transaction.setBalance(account.getAccountBalance());
                     transaction.setAccountNumber(accountNumber);
                    

                     session.save(transaction);

                     tx.commit();
                }else {
                	System.out.println("The Account you want to access is Deactive---- :)");
                }
               
            } else {
                System.out.println("Account not found with Number: " + accountNumber);
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Hibernate exception: " + e);
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Exception: " + e);
        }
    }


    @Override
    public void withdraw(long accountNumber, long amount) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Accounts account = session.createQuery("FROM Accounts WHERE accountNumber = :accountNumber", Accounts.class)
                    .setParameter("accountNumber", accountNumber)
                    .getSingleResult(); 
            
            if (account != null) {
            	if(account.getAccountStatus().equals("Active")) {
            		if (account.getAccountBalance() >= amount) {
                        account.setAccountBalance(account.getAccountBalance() - amount);
                        session.update(account);
                        
                        Transactions transaction = new Transactions();
                        transaction.setTransactionNumber(num.generateRandom10DigitNumber());
                        transaction.setTransactionType("Withdraw");
                        transaction.setTransactionsAmmount(amount);
                        transaction.setDateTime(dt.dateTime()); 
                        transaction.setBalance(account.getAccountBalance());
                        transaction.setAccountNumber(accountNumber);
                        session.save(transaction);
                        
                        tx.commit();
                    } else {
                        System.out.println("Insufficient balance in account: " + accountNumber);
                    }
                }else {
                	System.out.println("The Account you want to access is Deactive---- :)");
                }
                
            } else {
                System.out.println("Account not found with Number: " + accountNumber);
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Hibernate exception: " + e);
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Exception: " + e);
        }
    }

    @Override
    public List<Transactions> getAccountTransactions(long accountNumber) {
        try {
        	String query = "FROM Transactions WHERE accountNumber = :accountNumber";
        	 List<Transactions> t = session.createQuery(query,Transactions.class).setParameter("accountNumber", accountNumber).getResultList();
        	System.out.println("TransactionId"+query);
        	for (Transactions tr : t) {
        		System.out.println(tr);
        		}
        } catch (HibernateException e) {
            System.out.println("Hibernate exception: " + e);
        }
        return null;
    }

    

   
}

