import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Hospital } from 'src/app/classes/hospital';
import { Patient } from 'src/app/classes/patient';
import { HospitalService } from 'src/app/services/hospital.service';
import { AdminComponent } from '../admin/admin.component';



@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  hadd='';
  firstName='';
  patient=new Patient();
  hospital=new Hospital();
  hospitalArr:Hospital[]=[];
  checkAdmin:Boolean=false;
  showDiv:Boolean=false;
  

  constructor(private route:ActivatedRoute ,private router:Router,private hs:HospitalService,
    private snackBar: MatSnackBar
    ) {
    // this.patient= this.router.snapshot.params['billing']
    // console.log("session obj at dashboard="+sessionStorage.getItem('patient'));
    console.log("if admin="+this.route.snapshot.params['response']);
    // this.patient=this.router.snapshot.params['response'];
    this.patient = JSON.parse(this.route.snapshot.params['response']);
    this.firstName=this.patient.fname;
    console.log(this.patient);
    sessionStorage.setItem('user',JSON.stringify(this.patient));
    
    //this.patient = JSON.parse(this.router.snapshot.params['response']);
    // console.log("patient="+ this.patient.fname);
    // this.sessionStorage.setItem("name",(this.patient.fname+"  "+this.patient.lname));
        // console.log("session="+sessionStorage.key(1));
        
       
   }

  ngOnInit(): void {
    
    
    
    if(sessionStorage.getItem('admin') === "admin"){
      this.checkAdmin=true;
    }
    
  }


  getHospital(){
    this.hs.getHospital(1).subscribe(
      success=>{
        console.log(success);
        this.hospital=success;
       
      },
      error=>{
        console.log(error);
      }
    );
  }

  
  searchHospitals(){
  //  alert(this.hadd);
   this.hs.getHospitalByAddress(this.hadd).subscribe(
    success=>{
      console.log(success);
      this.hospitalArr=success;

      this.showDiv=true;
    },
    error=>{
      console.log(error);
      this.showDiv=false;
      this.snackBar.open('Error while fetching hospital', '', {
        duration: 2000
      });
    }
   );
   
  }

  bookAppointment(id:number){
    alert("inside bookAppointment id="+id);
    let hospitalId=this.hospital.hospitalId;
    let patinetId=this.patient.pid;
    // this.router.navigate(['/dashboard',{response:JSON.stringify(success)}]);
    // this.router.navigate(['/appointment',{response:JSON.stringify(hid)}]);
    this.router.navigate(['/appointment'],{queryParams: {hid: id,pid: patinetId}});

  }


  update(){
    // let patinetId=this.patient.pid;
    // this.ac.edit(patinetId);
  }

  delete(){
    // let patinetId=this.patient.pid;
    // this.ac.delete(patinetId);
  }
  

}
