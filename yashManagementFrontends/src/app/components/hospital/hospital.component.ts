import { ListKeyManager } from '@angular/cdk/a11y';
import { Component, OnInit } from '@angular/core';
import { Validators,FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/classes/doctor';
import { Hospital } from 'src/app/classes/hospital';
import { RoomCategory } from 'src/app/classes/room-category';
import { Speciality } from 'src/app/classes/speciality';
import { HospitalService } from 'src/app/services/hospital.service';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent implements OnInit {
  addHospital !: FormGroup;

  doc = new Doctor();
  spcty=new Speciality();
  hospital = new Hospital();
  roomCat=new RoomCategory();


  // spcty = new Speciality();
  // roomCat = new RoomCategory();
  // docArr:Array<Doctor>=[];
  // roomCatArr:Array<RoomCategory>=[];
  

  


  constructor(private hs: HospitalService, private fb: FormBuilder,private router:Router) { }

  ngOnInit(): void {
    this.addHospital=this.fb.group({
      hname:[''],
      haddress:[''],
      speciality:[''],
      dfname:[''],
      dLastName:[''],
      rcat:[''],
      rcatRate:[''],
      bedCount:['']
    });

  }


  getHospital() {
        
    this.hs.getHospital(1).subscribe(
      success => {
        this.hospital = success;
        console.log(this.hospital);
        console.log(this.hospital.address);
        

        this.addHospital.setValue({
          "hname":this.hospital.hospitalName,
          "haddress":this.hospital.address,
          "speciality":this.hospital.speciality.specialityName,
          "dfname":this.hospital.speciality.doctor.docFirstName,
          "dLastName":this.hospital.speciality.doctor.docLastName,
          "rcat":this.hospital.roomCategory.catName,
          "rcatRate":this.hospital.roomCategory.catRate
        });
      }, error => {
        console.log("hospital com " + error);
      }
    );

  }

  //  getSpeciality()  {

  //   this.hs.getSpecilaity().subscribe(
  //     success => {
  //       // this.doc=JSON.stringify(success);
  //       // this.doc=success;
  //       // console.log(success);

  //       this.spcty = success;
  //       console.log(this.spcty);
       
  //       // alert("docfirstname="+this.doc.docFirstName +"docLastName="+this.doc.docLastName);
  //       // console.log("hospital comp="+this.spcty.doctor.docFirstName);
  //       // this.doc= success.doctor;
  //       // console.log("obj doc="+this.doc.docFirstName);
  //       // console.log("obj doc="+this.doc.docLastName);


  //       // alert("hospital comp="+this.spcty.doctor.docFirstName);
  //       // alert("hospital comp="+this.spcty.doctor.docLastName);

  //       // console.log("id="+success.docId);
  //       // console.log("docfirstName="+success.docFirstName);
  //       // console.log("docLastName="+success.docLastName);
  //       // console.log("success at hospital component="+success);

  //     },
  //     error => {
  //       console.log("error at hospital component=" + error);

  //     }
  //   );

  // }


  // getDoctor() {
  //   this.hs.getDoctor().subscribe(
  //     success => {
  //       this.doc = success;
  //       console.log(success);
  //       alert("docfirstname=" + this.doc.docFirstName + " docLastName=" + this.doc.docLastName);
  //     },
  //     error => {
  //       console.log("error at Doctor component=" + error);
  //     }
  //   );

  // }

  submitHospitalForm(val:any){
    alert("hname= "+val.hname+"haddress= "+val.haddress+" speciality= "+val.speciality+" docFirstName="+
    val.dfname+" doclastName= "+val.dLastName+" cat="+val.rcat+" rate="+val.rcatRate+
    " bedCount="+val.bedCount
    );

    this.roomCat.catName=val.rcat;
    this.roomCat.catRate=val.rcatRate;

    this.doc.docFirstName=val.dfname;
    this.doc.docLastName=val.dLastName;

    this.spcty.specialityName=val.speciality;
    this.spcty.doctor=this.doc;

    
    this.hospital.hospitalName=val.hname;
    this.hospital.address=val.haddress;
    this.hospital.bedCount=val.bedCount;

    this.hospital.roomCategory=this.roomCat;
    this.hospital.speciality=this.spcty;
    console.log(this.hospital.roomCategory);
    console.log(this.hospital);
    
    this.hs.addHospitalData(this.hospital).subscribe(
      success=>{
        console.log(success);
        this.router.navigateByUrl("login");
      },error=>{
        console.log(error);
      });
  }

  cleanForm(){
    this.addHospital.reset();
    alert("form cleanned");
  }

}
