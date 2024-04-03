package com.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDaoImp implements UserDao {
	Session session ;
	private Transaction tx ;
	

	public UserDaoImp(Session session) {
		this.session = session;
	}

	
	 @Override
	    public void addUser(Accounts account) {
	        
	        try {
	            tx = session.beginTransaction();
	            session.save(account);
	            tx.commit();
	        } catch (HibernateException e) {
	            if (tx != null) tx.rollback();
	            e.printStackTrace();
	        } catch (Exception ee) {
	            if (tx != null) tx.rollback();
	            ee.printStackTrace();
	        }
	    }
	

	@Override
	public Accounts update(Accounts account) {
		try {
			tx= session.beginTransaction();
			Accounts existacc = session.createQuery("FROM Accounts WHERE accountNumber = :accountNumber", Accounts.class)
                    .setParameter("accountNumber", account.getAccountNumber())
                    .uniqueResult();
			existacc.setAccountNumber(account.getAccountNumber());
			existacc.setFirstName(account.getFirstName());
			existacc.setLastName(account.getLastName());
			existacc.setCustomerPhoneNumber(account.getCustomerPhoneNumber());
			existacc.setCustomerEmail(account.getCustomerEmail());
			existacc.setAdharNumber(account.getAdharNumber());
			existacc.setAccountBalance(existacc.getAccountBalance());
			session.update(existacc);
			tx.commit();
			return existacc;
		}catch(HibernateException e) {
			System.out.println("Hibernate expection is : "+e);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
		
	}

	@Override
	public Accounts display(long accountNumber) {
		try {
			Accounts account;
			account=session.get(Accounts.class, accountNumber);
			return account;
		} catch (HibernateException e) {
			System.out.println("Hibernate expection is : "+e);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void checkBalance(long accountNumber) {
	    try {
	        
	        Long accountBalance = session.createQuery("SELECT a.accountBalance FROM Accounts a WHERE a.accountNumber = :accountNumber", Long.class)
	                                     .setParameter("accountNumber", accountNumber)
	                                     .getSingleResult();

	        System.out.println("The remaining amount: " + accountBalance);
	        
	    } catch (HibernateException e) {
	        System.out.println("Hibernate exception is: " + e);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
