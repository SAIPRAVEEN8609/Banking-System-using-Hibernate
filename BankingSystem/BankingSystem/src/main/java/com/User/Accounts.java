package com.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Accounts")
public class Accounts {
	@Id
	@Column(name="accountNumber" ,length = 25)
	private long accountNumber;
	@Column(name = "firstName")
	private String firstName;
	private String lastName;

	
	@Column(name = "Email", length=40, unique=true)
	@Email(message = "Enter the valid Formate of the Email ")
	private String customerEmail;
	
	@Column(name="PhoneNumber",length=10, unique=true)
	@NotNull(message = "Enter the phone number it must not be empty  ")
	private long customerPhoneNumber;
	
	@Column(length=10, unique=true)
	@NotNull(message = "Enter the Pan card number it must not be empty  ")
	private String panCard;
	
	@Column(length=12, unique=true)
	@NotNull(message = "Enter the adhar number it must not be empty  ")
	private long adharNumber;
	
	private long accountBalance;
	
	private String accountStatus ;
	
	
	public Accounts() {
		super();
	}

	public Accounts( long accountNumber, String firstName,String lastName, String customerEmail, long customerPhoneNumber, String panCard,
			long adharNumber, long accountBalance,String accountStatus) {
		super();
		
		this.accountNumber=accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerEmail = customerEmail;
		this.customerPhoneNumber = customerPhoneNumber;
		this.panCard = panCard;
		this.adharNumber = adharNumber;
		this.accountBalance = accountBalance;
		this.accountStatus = accountStatus;
	}
	
	

	public Accounts( long accountNumber,String firstName, String lastName,
			@Email(message = "Enter the valid Formate of the Email ") String customerEmail,
			@NotNull(message = "Enter the phone number it must not be empty  ") long customerPhoneNumber,
			@NotNull(message = "Enter the Pan card number it must not be empty  ") String panCard,
			@NotNull(message = "Enter the adhar number it must not be empty  ") long adharNumber) {
		super();
		this.accountNumber=accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerEmail = customerEmail;
		this.customerPhoneNumber = customerPhoneNumber;
		this.panCard = panCard;
		this.adharNumber = adharNumber;
	}

	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public long getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(long adharNumber) {
		this.adharNumber = adharNumber;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "Accounts [accountNumber=" + accountNumber + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", customerEmail=" + customerEmail + ", customerPhoneNumber="
				+ customerPhoneNumber + ", panCard=" + panCard + ", adharNumber=" + adharNumber + ", accountBalance="
				+ accountBalance + "]";
	}

	

	
	

}
