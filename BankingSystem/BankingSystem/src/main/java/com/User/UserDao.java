package com.User;

public interface UserDao {

	public void addUser(Accounts account);
	public Accounts update(Accounts account);
	public Accounts display(long accountNumber);
	public void checkBalance(long accountNumber);

}
