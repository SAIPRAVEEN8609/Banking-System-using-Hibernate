package com.admin;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.User.Accounts;
import com.transactions.Transactions;

public class AdminDaoImpl implements AdminDao {
    private Session session;
    private Transaction tx = null;

    public AdminDaoImpl(Session session) {
        this.session = session;
    }
    @Override
    public void saveAdminCredentials(AdminCredentials adminCredentials) {
        try {
            tx = session.beginTransaction();
            session.save(adminCredentials);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Hibernate exception: " + e);
            if (tx != null) {
                tx.rollback();
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Accounts> getAllUsers() {
        try {
        	List<Accounts> acc = session.createQuery("FROM Accounts", Accounts.class).list();
        	for (Accounts accounts : acc) {
				System.out.println(accounts);
			}
        } catch (HibernateException e) {
            System.out.println("Hibernate exception: " + e);
            
        }
		return null;
    }

    @Override
    public List<Transactions> getAllTransactions() {
        try {
        	List<Transactions> tran= session.createQuery("FROM Transactions", Transactions.class).list();
        	for (Transactions transactions : tran) {
				System.out.println(transactions);
			}
        } catch (HibernateException e) {
            System.out.println("Hibernate exception: " + e);   
        }
		return null;
    }

    @Override
    public void deactivateAccount(long accountNumber) {
        try {
            tx = session.beginTransaction();
            String deactive = "Deactive";
            Accounts existacc = session.createQuery("FROM Accounts WHERE accountNumber = :accountNumber", Accounts.class)
                    .setParameter("accountNumber", accountNumber)
                    .getSingleResult(); 
            if(existacc!=null) {
            	existacc.setAccountStatus(deactive);
               
                tx.commit();
            }else {
                System.out.println("Account not found with id: " + accountNumber);
            }

        } catch (HibernateException e) {
            System.out.println("Hibernate exception: " + e);
            if (tx != null) {
                tx.rollback();
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public List<AdminCredentials> getAdminCredentials() {
        try {
        	List<AdminCredentials> admin;
            admin= session.createQuery("FROM AdminCredentials", AdminCredentials.class).getResultList();
           for (AdminCredentials adminCredentials : admin) {
			System.out.println(adminCredentials);
		}
                   
        } catch (HibernateException e) {
            System.out.println("Hibernate exception: " + e);
            
        }
        return null;
    }
}
