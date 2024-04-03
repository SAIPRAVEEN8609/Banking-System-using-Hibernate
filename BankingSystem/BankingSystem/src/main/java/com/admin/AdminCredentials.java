package com.admin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AdminCredentials")
public class AdminCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminId;
    private String username;
    private String password;

    public AdminCredentials() {
    }

    public AdminCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminCredentials{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
