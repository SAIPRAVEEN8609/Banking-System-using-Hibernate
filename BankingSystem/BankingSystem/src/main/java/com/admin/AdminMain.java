package com.admin;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class AdminMain {
    public  void admin( SessionFactory factory){
        Scanner sc = new Scanner(System.in);
        
        try {
          
            Session session = factory.openSession();         
            AdminDaoImpl adminDao = new AdminDaoImpl(session);
             
            System.out.print("Enter Admin Username: ");
            String adminUsername = sc.next();
            System.out.print("Enter Admin Password: ");
            String adminPassword = sc.next();

            AdminCredentials adminCredentials = new AdminCredentials("sharan", "9848");

            
            if (adminUsername.equals(adminCredentials.getUsername()) && adminPassword.equals(adminCredentials.getPassword())) {
              
                System.out.println("Admin authentication successful. You can now access admin functionalities.");
                
                    System.out.println("1. Fetch all users \t2. Fetch all transactions \t3. Deactivate account\t 4.fetch all admins \t5.Back");
                    int key = sc.nextInt();
                    switch (key) {
                        case 1:
                        	adminDao.getAllUsers();
                            break;
                        case 2:
                        	adminDao.getAllTransactions();
                            break;
                        case 3:
                            System.out.print("Enter the Account Number to deactivate: ");
                            long accountId = sc.nextLong();
                            adminDao.deactivateAccount(accountId);
                            break;
                        case 4:
                            adminDao.getAdminCredentials();
                            
                          break;
                        
                    }
                
            } else {
                System.out.println("Invalid admin credentials. Exiting...");
            }
      
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}