import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Event } from '../event';
import { EventService } from '../event.service';
import { UpdateEventComponent } from '../update-event/update-event.component';
@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {


  events :Event[];
  constructor(private eventService: EventService,private router:Router) { }

  ngOnInit(){
    this.getEvents();

   
  }
  private getEvents(){
    this.eventService.getEventsList().subscribe(data => {
      this.events =data;
    }); 

    
   
  }
  updateEvent(id:number){

    this.router.navigate(['update-event',id]);
  }

  deleteEvent(id:number){
    this.eventService.deleteEvent(id).subscribe(data => {
      console.log(data);
      this.getEvents();
    })
  }

}
