import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/classes/patient';
import {  Validators,FormGroup, FormBuilder } from '@angular/forms';
import { RegisterService } from 'src/app/services/register.service';
import { Route, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registrationForm !: FormGroup ;
  
  patient=new Patient();
  

    

  
  

  constructor(private rs:RegisterService, private fb:FormBuilder,private router:Router,
    private snackBar: MatSnackBar
    ) { 
    
  
  }

  ngOnInit(): void {
    this.registrationForm=this.fb.group({
      fname:['',Validators.required],
      mname:['',Validators.required],
      lname:['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      password:['',Validators.required],
      cpassword:['',Validators.required],
  
    });
  }

  submitForm(){
    console.log("inside submitForm fname "+this.patient.fname);    
    console.log("inside submitForm mname "+this.patient.mname);    
    console.log("inside submitForm lname "+this.patient.lname);    
    console.log("inside submitForm email "+this.patient.email);    
    console.log("inside submitForm password "+this.patient.password);    
    this.rs.registerPatient(this.patient);
  }

  submitRegisterationForm(val:any){
    var firstName=val.fname;
    var middleName=val.mname;
    var lastName=val.lname;
    var email=val.email;
    var pass=val.password;
    var cpass=val.cpassword;
    console.log("Fname="+firstName+" middle="+middleName+" lastName="+lastName);
    console.log("email="+email+" pass="+pass+" cpwd="+cpass);
    this.rs.registerPatient(this.registrationForm.value).subscribe(
      success=>{
        console.log(success);
        this.router.navigate(['/dashboard',{response:JSON.stringify(success)}]);
      },error=>{
        console.error(error);
        this.snackBar.open('Error', '', {
          duration: 2000
        });
      }
      
    );
    
  }
}
