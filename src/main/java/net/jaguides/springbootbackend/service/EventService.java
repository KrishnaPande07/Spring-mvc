package net.jaguides.springbootbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import net.jaguides.springbootbackend.model.Event;
import net.jaguides.springbootbackend.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> addAllEvents(List<Event> events) {
        return eventRepository.saveAll(events);
    }

    public Event getEventByID(long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event updateEvent(Event event, long id) {
        Event existingEVE = eventRepository.findById(id).orElse(null);
        System.out.println(event);
        if(existingEVE == null) {
            System.out.println("Event not found");
            return  null;
        }else  {
            existingEVE.setEventname(event.getEventname());
            existingEVE.setEventlocation(event.getEventlocation());
            existingEVE.setDate(event.getDate());
            eventRepository.save(existingEVE);
        }
        return event;
    }
    public boolean deleteEventByID(long id) {
        Event existingEVE= eventRepository.getById(id);
        if(existingEVE != null) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
















