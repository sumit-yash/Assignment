import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Patient } from 'src/app/classes/patient';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  updatedForm!: FormGroup;
  id!:number;
  patient = new Patient();

  constructor(private fb: FormBuilder, private ps: PatientService, private router: Router,
    private route: ActivatedRoute,private snackBar: MatSnackBar
  ) {
    this.id=Number (this.route.snapshot.paramMap.get('id'));
    this.getUpdateForm(this.id);
  }

  ngOnInit(): void {
    this.updatedForm = this.fb.group({
      fname: [''],
      mname: [''],
      lname: [''],
      email: [''],
      password: [''],
      cpassword: [''],
    });



  }


  submitUpdateForm(val: any) {
    console.log("Fname=" + val.fname + " middle=" + val.mname + " lastName=" + val.lname);
    console.log("email=" + val.email + " pass=" + val.password + " cpwd=" + val.cpassword);
    val.pid =this.id;
    this.ps.updatePatient(this.updatedForm.value).subscribe(
      success => {
        this.snackBar.open('Submitted Successfully', '', {
          duration: 2000
        });
        this.router.navigateByUrl("/admin");
        console.log(success);
       
      },
      error => {
        console.log(error);
        this.snackBar.open('Error while submitting data', '', {
          duration: 2000
        });
      }
    );

  }

  getUpdateForm(id: number) {
    this.ps.getPatient(id).subscribe(
      success => {
        console.log(success);
        this.patient = success;
        this.patient.pid = id;
        this.updatedForm.setValue({
          "fname": this.patient.fname,
          "mname": this.patient.mname,
          "lname": this.patient.lname,
          "email": this.patient.email,
          "password": this.patient.password,
          "cpassword": ""
        });
      },
      error => {
        console.log(error);
        this.snackBar.open('Error fetching data', '', {
          duration: 2000
        });
      }
    );
  }



  cleanForm() {
    this.updatedForm.reset();
    alert("form cleanned");
  }

}