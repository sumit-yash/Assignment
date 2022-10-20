import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Speciality } from '../classes/speciality';

@Injectable({
  providedIn: 'root'
})
export class SpecialityService {

  url: string = "http://localhost:8088/";

  constructor(public http: HttpClient) { }

  addSpeciality(spec:Speciality){
    return this.http.post(this.url+'speciality/addSpeciality',spec);
   }
 
   getSpeciality(name:string){
     return this.http.get<Speciality>(this.url+'speciality/'+name);
    }
}
