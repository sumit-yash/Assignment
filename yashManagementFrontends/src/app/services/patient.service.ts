import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from '../classes/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  val="";
  url: string = "http://localhost:8088/";

  constructor(public http: HttpClient) { }


  getAllPatients() {
    return this.http.get<Patient[]>(this.url + 'patient/all');
  }

  getPatient(id:number){
    return this.http.get<Patient>(this.url+'patient/'+id);
   }

   updatePatient(patient:Patient){
    return this.http.put<Patient>(this.url+'patient/'+patient.pid,patient);
   }

   deletePatient(id:number){
      return this.http.delete(this.url+'patient/'+id,{responseType:'text'});
   }

}
