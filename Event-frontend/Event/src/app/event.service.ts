import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Event } from './event';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private baseURL = "http://localhost:8080/api/v1/events";

  constructor(private httpClient : HttpClient) { 
    
  }

  getEventsList(): Observable<Event[]>
  {
    return this.httpClient.get<Event[]>(this.baseURL +'/getAll');
   
  }  


    createEvent(event:Event):Observable<Object>{

      return this.httpClient.post(this.baseURL+'/addEvent',event);
    }

    getEventById(id:number):Observable<Event>{
      return this.httpClient.get<Event>(this.baseURL+'/getEventByID/{id}');
    }

 updateEvent(id:number,event: Event):Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/updateEvent/${id}`,event);
 }

 deleteEvent(id:number):Observable<Object>
{
  return this.httpClient.delete(`${this.baseURL}/deleteEventById/${id}`);
}
}
