import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Login } from 'src/app/classes/login';
import { Patient } from 'src/app/classes/patient';
import { LoginService } from 'src/app/services/login.service';
import { HospitalComponent } from '../hospital/hospital.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  header: string = "Login";
  // login = new Login();
  patient = new Patient();
  loginForm!:FormGroup;

  constructor(
    private ls: LoginService, public http: HttpClient, private router: Router,
    private snackBar: MatSnackBar, private route: ActivatedRoute, private fb:FormBuilder
  ) { }

  ngOnInit(): void {
    this.loginForm=this.fb.group({
      email:['',Validators.email],
      password:['',Validators.required]
    });
  }

  loginSubmit(val:any) {
    console.log("@component email=" +this.loginForm.value.email + " and password= " + this.loginForm.value.password);
    if (this.loginForm.value.email === 'admin' && this.loginForm.value.password === 'admin') {
      alert("admin side");
      sessionStorage.setItem('admin', "admin");
      // this.router.navigate(['/dashboard', { response: JSON.stringify("admin")}]);
      this.router.navigate(['/admin', { response: JSON.stringify("admin")}]);
      
    } else {

      this.ls.checkLogin(this.loginForm.value).subscribe(
        success => {
          console.log(success);
          this.patient=success;
          // this.navigate("/dashboard",success);
          // this.router.navigate(['dashboard'], { relativeTo: this.loginSubmit })
          sessionStorage.setItem("user",'patient');
          this.router.navigate(['/dashboard',{response:JSON.stringify(success)}]);
          // this.sessionStorage.setItem("isValid","true");
          
          

        }, error => {
          console.error(error);
          // this.msg=;
          // this.snackBar.open("bad credential");
          this.snackBar.open('Bad Credential', '', {
            duration: 2000
          });
        }
      );
    }
  }

  // navigate(link: String, obj: any) {
  //   this.router.navigate(['link', { response: JSON.stringify(obj) }]);
  // }


}
