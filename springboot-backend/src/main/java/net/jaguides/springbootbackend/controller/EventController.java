package net.jaguides.springbootbackend.controller;
import net.jaguides.springbootbackend.exception.ResourceNotFoundException;
import net.jaguides.springbootbackend.model.Event;
import net.jaguides.springbootbackend.repository.EventRepository;
import net.jaguides.springbootbackend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins ="*")
//@CrossOrigin ("*")
@RestController
@RequestMapping("/api/v1/events")

public class EventController {


    @Autowired
    private EventService eventService;


    @GetMapping("/getAll")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }


    //build create  event rest api
    @PostMapping("/addEvent")
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    // Add more than 1 event
    @PostMapping("/addEvents")
    public List<Event> addAllEvents(@RequestBody List<Event> events) {
        return eventService.addAllEvents(events);
    }


    // buil get event by id rest api

    @GetMapping("/getEventByID/{id}")
    public Event getEventById(@PathVariable long id) {
        return eventService.getEventByID(id);
    }

    // Update event
    @PutMapping("/updateEvent/{id}")
    public Event updateEvent(@RequestBody Event event,@PathVariable long id) {
        return eventService.updateEvent(event,id);
    }

    // Delete event
    @DeleteMapping("/deleteEventById/{id}")
    public boolean deleteEventByID(@PathVariable long id) {
        return eventService.deleteEventByID(id);
    }
}