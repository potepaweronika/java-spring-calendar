package com.calendar;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String email;
    private String password;

    private Map<String, String> allUsers;

    public UserDetails() {
        allUsers = new HashMap<>();
        readUsersFromFile();
    }

    public void addUser() {
        allUsers.put(getUsername(), getPassword());
        writeUsersToFile();
    }

    private synchronized void readUsersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            allUsers = (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            allUsers = new HashMap<>();
        }
    }

    private synchronized void writeUsersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"))) {
            oos.writeObject(allUsers);
        } catch (IOException e) {
            // Handle or log the exception
            e.printStackTrace();
        }
    }

    // Getter and setter methods...

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


    // Other methods...
}
