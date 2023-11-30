package com.calendar.repository;

import com.calendar.model.User;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, User> allUsers;

    public UserDetails() {
        allUsers = new HashMap<>();
        readUsersFromFile();
    }

    public void addUser(User user) {
        allUsers.put(user.getUsername(), user);
        writeUsersToFile();
    }

    private synchronized void readUsersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            allUsers = (Map<String, User>) ois.readObject();
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
    public Map<String, User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(Map<String, User> allUsers) {
        this.allUsers = allUsers;
    }
}
