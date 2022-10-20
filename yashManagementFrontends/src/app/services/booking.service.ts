import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from '../classes/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  baseUrl: String = "http://localhost:8088/booking";
  constructor(public http: HttpClient) { }

  addBooking(data: Booking) {
    console.log(data);
     return this.http.post<Booking>(this.baseUrl + '/add', data);
  }

  getBooking(id:number) {
    return this.http.get<Booking>(this.baseUrl + '/'+id);
  }
}
