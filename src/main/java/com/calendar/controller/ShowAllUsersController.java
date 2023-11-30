package com.calendar.controller;

import com.calendar.model.User;
import com.calendar.repository.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Map;

@Controller
public class ShowAllUsersController {

    private final UserDetails userDetails;

    public ShowAllUsersController(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @GetMapping("/showAll")
    public String showAllUsers(Model model) {
        Collection<User> allUsers = userDetails.getAllUsers().values();
        model.addAttribute("users", allUsers);
        return "show-all-users";
    }
}
