import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Doctor } from 'src/app/classes/doctor';
import { Speciality } from 'src/app/classes/speciality';
import { SpecialityService } from 'src/app/services/speciality.service';

@Component({
  selector: 'app-speciality',
  templateUrl: './speciality.component.html',
  styleUrls: ['./speciality.component.css']
})
export class SpecialityComponent implements OnInit {
  specialityForm!:FormGroup;
  specialityName='';
  doc=new Doctor();
  speciality=new Speciality();

  constructor(private fb:FormBuilder,private ss:SpecialityService, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.specialityForm=this.fb.group({
      sname:[''],
      docfname:[''],
      doclname:['']
    });
  }


  submitSpeciality(val:any){
    alert(
      "speciality="+val.sname+" docFirstName="+val.docfname+
      " docLastName="+val.doclname
    );
      this.doc.docFirstName=val.docfname;
      this.doc.docLastName=val.doclname;

      this.speciality.specialityName=val.sname;
      this.speciality.doctor=this.doc;
      this.ss.addSpeciality(this.speciality).subscribe(
        success=>{
          console.log(success);
        },error=>{
          console.log(error);
          this.snackBar.open('Error While adding Speciality', '', {
            duration: 2000
          });
          
        }
      );
      

  }

  getSpeciality(){
    this.ss.getSpeciality(this.specialityName).subscribe(
      success=>{
        console.log(success);
        this.speciality=success;
        // var sp=this.speciality.specialityName;
        // alert("sp="+sp);
        this.doc=this.speciality.doctor;

        this.specialityForm.setValue({
          "sname":this.speciality.specialityName,
          "docfname":this.doc.docFirstName,
          "doclname":this.doc.docLastName
        });
      },error=>{
        console.log(error);
        this.snackBar.open('Invalid Speciality', '', {
          duration: 2000
        });
        
      }
    );
  }
    
    

}
