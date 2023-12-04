package com.calendar.controller.admin;

import com.calendar.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class ShowAllUsersController {
    private final UserService userService;

    @Autowired
    public ShowAllUsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/show-all-users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin/show-all-users";
    }
}
