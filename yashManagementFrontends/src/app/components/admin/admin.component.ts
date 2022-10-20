import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Patient } from 'src/app/classes/patient';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  patient = new Patient();
  patientArr: Patient[] = [];
  showPatientList:boolean=false;
  addSpeciality:boolean=false;
  getSpeciality:boolean=false;
  addHospital:boolean=false;

  constructor(private ps: PatientService, private router: Router,private snackBar: MatSnackBar) {
    // this.getPatient();
    this.getAllPatient();
  }

  ngOnInit(): void {
  }

  getPatient(id:number) {
  this.ps.getPatient(id).subscribe(
      success => {
        this.patient = success;
        console.log(success);

      }, error => {
        console.log(error);

      }
    );

  }

  getAllPatient() {
    this.ps.getAllPatients().subscribe(
      success => {
        console.log(success);
        this.patientArr = success;
      },
      error => {
        console.log(error);
      }
    );
  }


  edit(id: number) {
    // alert("id=" + id);
    this.router.navigateByUrl("/update/" + id);
  }

  delete(id: number) {
    // alert("deleteId=" + id);
    this.ps.deletePatient(id).subscribe(
      success => {
        console.log(success);
        // alert("success delete");
        window.location.reload();
        this.snackBar.open(success, '', {
          duration: 2000
        });
      }, error => {
        console.log(error);
        // alert("error delete");
        window.location.reload();
        this.snackBar.open(error, '', {
          duration: 2000
        });
      }
    );

  }

  toggle(st:string){
    if(st === 'showPatientList'){
      this.showPatientList=true;
      this.addHospital=false;
      this.getSpeciality=false;
      this.addSpeciality=false;
    }
    if(st === 'addHospital'){
      this.addHospital=true;
      this.showPatientList=false;
      this.getSpeciality=false;
      this.addSpeciality=false;
    }
    if(st === 'getSpeciality'){
      this.addHospital=false;
      this.showPatientList=false;
      this.getSpeciality=true;
      this.addSpeciality=false;
    }
    if(st === 'addSpeciality'){
      this.addSpeciality=true;
      this.addHospital=false;
      this.showPatientList=false;
      this.getSpeciality=false;
    }
    
  }

}
