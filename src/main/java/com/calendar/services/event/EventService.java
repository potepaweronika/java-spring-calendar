package com.calendar.services.event;

import com.calendar.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    void save(Event event);

    List<Event> getAll();

    Event findById(Long eventId);

    void delete(Event event);
}
