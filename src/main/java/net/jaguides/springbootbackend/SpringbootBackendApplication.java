package net.jaguides.springbootbackend;

import net.jaguides.springbootbackend.model.Event;
import net.jaguides.springbootbackend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EventRepository eventRepository;

	/*@Override
	public void run(String... args) throws Exception {
		Event event = new Event();
		event.setEventname("Presentation");
        event.setEventlocation("Ghatkopar");
		event.setEmailId("Krishna@123gmail.com");
		eventRepository.save(event);

		Event event1 = new Event();
		event1.setEventname("Succsess Party");
		event1.setEventlocation("Ghatkopar");
		event1.setEmailId("Ramesh@gmail.com");
		eventRepository.save(event1); */
	}

