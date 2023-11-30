package com.calendar.repository;

import com.calendar.model.Event;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class EventDetails implements Serializable{
    private Map<String, Event> allEvents;

    public EventDetails() {
        allEvents = new HashMap<>();
        readEventsFromFile();
    }

    public void addEvents(Event event) {
        allEvents.put(event.getTitle(), event);
        writeEventsToFile();
    }

    private synchronized void readEventsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("events.dat"))) {
            allEvents = (Map<String, Event>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            allEvents = new HashMap<>();
        }
    }

    private synchronized void writeEventsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("events.dat"))) {
            oos.writeObject(allEvents);
        } catch (IOException e) {
            // Handle or log the exception
            e.printStackTrace();
        }
    }

    public Map<String, Event> getAllEvents() {
        return allEvents;
    }

    public void setAllEvents(Map<String, Event> allEvents) {
        this.allEvents = allEvents;
    }
}
