package com.calendar;

import java.util.Map;

public class LoginData {
    private String username;
    private String password;
    private Map<String, String> allUsers;

    // getters and setters...

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

    public Map<String, String> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(Map<String, String> allUsers) {
        this.allUsers = allUsers;
    }
}
