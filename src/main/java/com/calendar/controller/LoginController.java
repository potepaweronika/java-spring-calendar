package com.calendar.controller;

import com.calendar.model.User;
import com.calendar.repository.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginData", new User());
        return "login-form";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute User loginData, Model model) {
        String username = loginData.getUsername();
        String password = loginData.getPassword();

        UserDetails users = new UserDetails();
        Map<String, User> allUsers = users.getAllUsers();

        if (allUsers.containsKey(username)) {
            User storedUser = allUsers.get(username);
            if (storedUser.getPassword().equals(password)) {
                model.addAttribute("successMessage", "User successfully logged in.");
                model.addAttribute("user", storedUser);
                return "login-success";
            } else {
                model.addAttribute("errorMessage", "Wrong password!");
                return "login-form";
            }
        } else {
            model.addAttribute("errorMessage", "Wrong username!");
            return "login-form";
        }
    }
}

