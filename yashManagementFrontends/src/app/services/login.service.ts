import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RouterLink, RouterLinkWithHref } from '@angular/router';
import { Login } from '../classes/login';
import { Router } from '@angular/router';
import { Patient } from '../classes/patient';
import { computeMsgId } from '@angular/compiler';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  url: string = "http://localhost:8088/login";
  
  constructor(public http: HttpClient,private router: Router) { }

  public checkLogin(loginData: Login) {
     return this.http.post<Patient>(this.url, loginData);
  }

  
}
