package com.calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDetails", new UserDetails());
        return "registration";
    }

    @PostMapping("/registration")
    public String processRegistration(@ModelAttribute UserDetails userDetails, Model model) {
        if (userDetails.getAllUsers().containsKey(userDetails.getUsername())) {
            model.addAttribute("errorMessage", "Username already taken!");
            return "registration";
        } else {
            userDetails.addUser();
            model.addAttribute("successMessage", "Registration successful!");
            model.addAttribute("allUsers", userDetails.getAllUsers());
            return "registration-success";
        }
    }
}
