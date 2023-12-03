package com.calendar.controller;

import com.calendar.services.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllEventsController {
    private final EventService eventService;

    @Autowired
    public ShowAllEventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/show-all-events")
    public String showAllEvents(Model model) {
        model.addAttribute("events", eventService.getAll());
        return "show-all-events";
    }
}
