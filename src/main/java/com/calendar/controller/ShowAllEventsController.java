package com.calendar.controller;

import com.calendar.model.Event;
import com.calendar.repository.EventDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class ShowAllEventsController {
    private final EventDetails eventDetails;

    public ShowAllEventsController(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    @GetMapping("/show-all-events")
    public String showAllEvents(Model model) {
        Collection<Event> allEvents = eventDetails.getAllEvents().values();
        System.out.println(allEvents);
        System.out.println(eventDetails.getAllEvents());
        model.addAttribute("events", allEvents);
        return "show-all-events";
    }
}
