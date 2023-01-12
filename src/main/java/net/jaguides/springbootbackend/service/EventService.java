package net.jaguides.springbootbackend.service;

import net.jaguides.springbootbackend.model.Event;
import net.jaguides.springbootbackend.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;
public class EventService {

    private static EventRepository eventRepository;
    public static void saveEvents(List<Event> events)
    {
        int size = events.size();
        int counter =0;
        List<Event> temp = new ArrayList<>();
        for(Event evt : events){
            temp.add(evt);

            if((counter+1)%500==0 || (counter+1)==size){
                eventRepository.saveAll(temp);
                temp.clear();
            }
            counter++;
        }



    }


}
