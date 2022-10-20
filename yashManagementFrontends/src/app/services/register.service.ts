import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from '../classes/patient';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  baseUrl:String="http://localhost:8088";
  constructor(public http:HttpClient,private router: Router) { }


  public registerPatient(patient:Patient){
   return this.http.post(this.baseUrl+"/patient/add",patient);
  }
}
