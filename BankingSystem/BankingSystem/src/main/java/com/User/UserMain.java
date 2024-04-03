package com.User;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserMain {
	public  void user(SessionFactory factory){
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Session session =factory.openSession();
			UserDaoImp user = new UserDaoImp(session);

			
				System.out.println("1.create account \n2.check account details \n3.Check Balance \n4.Update info \n5.Back");
				System.out.print("Enter your choise :");
				int choise =sc.nextInt();
				switch (choise) {
				case 1:
					System.out.print("Enter account number : ");
					long accountNumber = sc.nextLong();
					System.out.print("Enter the customer First name: ");
					String firstName = sc.next();
					System.out.print("Enter the customer Last name: ");
					String lastName = sc.next();
					
					System.out.print("Enter the customer email : ");
					String email = sc.next();
					System.out.print("Enter the customer phone number : ");
					long phoneNumber = sc.nextLong();
					System.out.print("Enter the customer pan card : ");
					String panCard = sc.next();
					System.out.print("Enter the Adhar number : ");
					long adharNumber = sc.nextLong();
					System.out.print("Enter the deposit ammount (min 1000) : ");
					long amount =sc.nextLong();
					String accountStatus="Active";
					
					
					Accounts account = new Accounts( accountNumber,firstName,lastName, email, phoneNumber, panCard, adharNumber, amount,accountStatus);
					user.addUser(account);
					break;
				case 2:
					System.out.print("Enter the account number : ");
					accountNumber = sc.nextLong();
					System.out.println(user.display(accountNumber)); 
					break;
				case 3:
					System.out.print("Enter the account number : ");
					accountNumber = sc.nextLong();
					user.checkBalance(accountNumber);
					break;
				case 4:
					
					System.out.print("Enter account number : ");
					accountNumber = sc.nextLong();
					System.out.print("Enter the customer First name: ");
					firstName = sc.next();
					System.out.print("Enter the customer Full name: ");
					lastName = sc.next();
					
					System.out.print("Enter the email : ");
					email = sc.next();
					System.out.print("Enter the phone number : ");
					phoneNumber = sc.nextLong();
					System.out.print("Enter the pan card : ");
					panCard = sc.next();
					System.out.print("Enter the Adhar number : ");
					adharNumber = sc.nextLong();
					
					
					
					Accounts account1 = new Accounts(accountNumber, firstName,lastName, email, phoneNumber, panCard, adharNumber);
					user.update(account1);
					break;
				
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			sc.close();
			
		}
	}
}
