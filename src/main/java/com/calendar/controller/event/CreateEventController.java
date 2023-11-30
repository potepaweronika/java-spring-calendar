package com.calendar.controller.event;

import com.calendar.model.Event;
import com.calendar.repository.EventDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class CreateEventController {
    @GetMapping("/create-event")
    public String showCreateEventForm(Model model) {
        model.addAttribute("newEvent", new Event());
        return "event/create-event-form";
    }

    @PostMapping("/create-event")
    public String processCreateEvent(@ModelAttribute Event newEvent, Model model) {
        EventDetails events = new EventDetails();
        events.addEvents(newEvent);
        model.addAttribute("successMessage", "Event created successfully!");
        model.addAttribute("newEvent", newEvent);
        return "event/create-event-form";
    }
}
