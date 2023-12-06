package com.calendar.controller.event;

import com.calendar.model.Event;
import com.calendar.model.User;
import com.calendar.services.event.EventService;
import com.calendar.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/create-event")
public class CreateEventController {

    private final EventService eventService;
    private final UserService userService;

    @Autowired
    public CreateEventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @ModelAttribute("event")
    public Event Event() {
        return new Event();
    }

    @GetMapping
    public String showCreateEventForm() {
        return "event/create-event";
    }

    @PostMapping
    public String createEvent(@ModelAttribute("event") Event event) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        // Fetch the user from the database using email
        User currentUser = userService.findByEmail(currentUserEmail);

        // Add the event to the user's list of events
        event.setUser(currentUser);
        currentUser.getEvents().add(event);

        // Save the updated user (which will cascade to save the event)
        userService.saveUser(currentUser);

        // Redirect to a success page or wherever you want
        return "redirect:/";
    }
}
