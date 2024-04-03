package com.admin;

import java.util.List;
import com.User.Accounts;
import com.transactions.Transactions;

public interface AdminDao {
	 public void saveAdminCredentials(AdminCredentials adminCredentials) ;
    List<Accounts> getAllUsers();
    List<Transactions> getAllTransactions();
    void deactivateAccount(long accountId);
    public List<AdminCredentials> getAdminCredentials() ;
}