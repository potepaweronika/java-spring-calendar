package com.calendar.controller.user;

import com.calendar.model.User;
import com.calendar.services.event.EventService;
import com.calendar.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/delete-user/{userId}")
public class DeleteUserController {
    public final UserService userService;
    public final EventService eventService;

    @Autowired
    public DeleteUserController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    @ModelAttribute("user")
    public User User() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        // Fetch the user from the database using email and return user
        return userService.findByEmail(currentUserEmail);
    }

    @GetMapping
    public String showDeleteUserForm() { return "user/delete-user"; }

    @PostMapping
    public String deleteUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        userService.delete(user);

        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.setInvalidateHttpSession(true);
        logoutHandler.logout(request, null, null);

        return "redirect:/";
    }
}
