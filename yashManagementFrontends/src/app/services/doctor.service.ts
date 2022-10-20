import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Doctor } from '../classes/doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  url: string = "http://localhost:8088/";

  constructor(public http: HttpClient) { }

  addDoctor(doc:Doctor){
   return this.http.post(this.url+'/doctor/add',doc);
  }

  getDoctor(id:number){
    return this.http.get(this.url+'/doctor/'+id);
   }
}
