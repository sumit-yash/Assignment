import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from '../classes/doctor';
import { Hospital } from '../classes/hospital';
import { Speciality } from '../classes/speciality';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  url: string = "http://localhost:8088/";

  constructor(public http: HttpClient) { }

  public addHospitalData(hspt: Hospital) {
    console.log(hspt);
    return this.http.post<Hospital>(this.url + 'hospital/add', hspt);
  }

  public getHospital(id:number) {
    return this.http.get<Hospital>(this.url + "hospital/"+id);
  }

  public getHospitalByAddress(hospitalAddress:string) {
    // return this.http.get(this.url+'getAll');
    return this.http.get<Hospital[]>(this.url + "hospital/address/"+hospitalAddress);
  }

  public getAllHospital() {
    // return this.http.get(this.url+'getAll');
    return this.http.get<Hospital>(this.url + "hospital/getAll");
  }

  public getDoctor() {
    return this.http.get<Doctor>(this.url +"doctor/1");
  }

  public getSpecilaity() {
    return this.http.get<Speciality>(this.url+"speciality/all");
  }

  
}
