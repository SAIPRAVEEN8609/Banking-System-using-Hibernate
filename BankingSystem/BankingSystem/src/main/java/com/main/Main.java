package com.main;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.User.UserMain;
import com.admin.AdminMain;
import com.transactions.TransactionsMain;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			SessionFactory factory;
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			UserMain users = new UserMain();
			TransactionsMain transactions = new TransactionsMain();
			AdminMain admins = new AdminMain();
			boolean bool1 = true;
			while(bool1) {
				System.out.println("1.User \t2.Transaction \t3.Admin \t4.Close");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					users.user(factory);
					break;
				case 2:
					transactions.transaction(factory);
					break;
				case 3:
					admins.admin(factory);
					break;
				case 4 :
					bool1 = false;
					break;
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
