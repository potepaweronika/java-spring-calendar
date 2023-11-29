package com.calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginData", new LoginData());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute LoginData loginData, Model model) {
        String username = loginData.getUsername();
        String password = loginData.getPassword();

        Map<String, String> allUsers = loginData.getAllUsers();

        if (allUsers.containsKey(username)) {
            if (allUsers.get(username).equals(password)) {
                model.addAttribute("successMessage", "User successfully logged in.");
                model.addAttribute("username", username);
                model.addAttribute("password", password);
                return "login-success";
            } else {
                model.addAttribute("errorMessage", "Wrong password!");
            }
        } else {
            model.addAttribute("errorMessage", "Wrong username!");
        }

        return "login";
    }
}

