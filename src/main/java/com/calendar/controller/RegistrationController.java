package com.calendar.controller;

import com.calendar.model.User;
import com.calendar.repository.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new User());
        return "registration-form";
    }

    @PostMapping("/registration")
    public String processRegistration(@ModelAttribute User newUser, Model model) {
        UserDetails users = new UserDetails();
        if (users.getAllUsers().containsKey(newUser.getUsername())) {
            model.addAttribute("errorMessage", "Username already taken!");
            return "registration-form";
        } else {
            users.addUser(newUser);
            model.addAttribute("successMessage", "Registration successful!");
            model.addAttribute("newUser", newUser);
            return "registration-success";
        }
    }
}
