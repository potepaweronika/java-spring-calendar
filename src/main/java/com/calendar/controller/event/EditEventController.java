package com.calendar.controller.event;

import com.calendar.model.Event;
import com.calendar.services.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/edit-event/{eventId}")
public class EditEventController {
    public final EventService eventService;

    @Autowired
    public EditEventController(EventService eventService) {
        this.eventService = eventService;
    }

    @ModelAttribute("event")
    public Event Event(@PathVariable Long eventId) {
        return eventService.findById(eventId);
    }

    @GetMapping
    public String showEditEventForm() {
        return "event/edit-event-form";
    }

    @PostMapping
    public String editEvent(@ModelAttribute("event") Event event) {
        // Save changes made to event
        eventService.save(event);

        // Redirect to a success page or wherever you want
        return "redirect:/";
    }
}
