import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Hospital } from 'src/app/classes/hospital';
import { HospitalService } from 'src/app/services/hospital.service';
import {MatDatepicker, MatDatepickerModule} from '@angular/material/datepicker';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/classes/patient';
import { PatientService } from 'src/app/services/patient.service';
import { Receipt } from 'src/app/classes/receipt';
import { AdminComponent } from '../admin/admin.component';
import { ReceiptService } from 'src/app/services/receipt.service';
import { Speciality } from 'src/app/classes/speciality';
import { Doctor } from 'src/app/classes/doctor';
import { Booking } from 'src/app/classes/booking';
import { RoomCategory } from 'src/app/classes/room-category';
import { BookingService } from 'src/app/services/booking.service';
import { Observable } from 'rxjs';
import { MatDatepickerInput } from '@angular/material/datepicker';
import { DatePipe, formatDate, getLocaleDateFormat, getLocaleDateTimeFormat } from '@angular/common';



@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {
  appointmentForm!:FormGroup
  ht=new Hospital();
  pt=new Patient();
  spty=new Speciality();
  dr=new Doctor();
  addedReceipt=new Receipt();
  bk=new Booking();
  // booked=new Booking();
  rc=new RoomCategory();
  hid=0;
  pid=0;
  receiptId=0;
  bedCount=0;
  
  constructor(private fb:FormBuilder,private hs:HospitalService, private route: ActivatedRoute,private router: Router,
    private s:PatientService,private bs:BookingService,private dp:DatePipe
    ) {
    
      console.log("user="+sessionStorage.getItem('user'));
      var st=sessionStorage.getItem('user');
      this.pt=JSON.parse(st+"");
      this.route.queryParams.subscribe(params => {
        this.hid = params['hid'];
        this.pid = params['pid'];
        // alert("hid="+this.hid);
        // alert("pid="+this.pid);
        this.getHospital(this.hid);
    });

    
   }

  ngOnInit(): void {
    this.appointmentForm=this.fb.group({
      hname:['',],
      haddress:[''],
      spty:[''],
      dfname:[''],
      dLastName:[''],
      rcat:[''],
      rcatRate:[''],
      bedCount:[''],
      picker1:['',Validators.required],
      picker2:['',Validators.required],
    });

    this.appointmentForm.get('picker1')?.valueChanges.subscribe(date => {
      const dateTwo = formatDate(new Date(), 'MM/dd/yyyy', 'en');
      this.appointmentForm.get('picker2')?.setValue(dateTwo);
    });
   
   


  }

  getHospital(id:number) {
        
    this.hs.getHospital(id).subscribe(
      success => {
        this.ht = success;
        console.log(this.ht);

        this.appointmentForm.setValue({
          "hname":this.ht.hospitalName,
          "haddress":this.ht.address,
          "spty":this.ht.speciality.specialityName,
          "dfname":this.ht.speciality.doctor.docFirstName,
          "dLastName":this.ht.speciality.doctor.docLastName,
          "rcat":this.ht.roomCategory.catName,
          "rcatRate":this.ht.roomCategory.catRate,
          "bedCount":this.ht.bedCount,
          "picker1":"",
          "picker2":""
        });
      }, error => {
        console.log("hospital com " + error);
      }
    );

  }
  
  // submitAppointmentForm(value:any){
  //   alert("hname= "+value.hname +"haddress= "+value.haddress+" spty= "+value.spty+" docFirstName="+
  //   value.dfname+" doclastName= "+value.dLastName+" cat="+value.rcat+" rate="+value.rcatRate
  //   );

    
  //   // this.router.navigate(['/receipt'],{queryParams: { id : receiptId}});
  // }

  submitAppointmentForm(val:any){
    // alert("start date= "+val.picker1+" end date = "+val.picker2);

    this.rc.catName=val.rcat;
    this.rc.catRate=val.rcatRate;

    this.dr.docFirstName=val.dfname;
    this.dr.docLastName=val.dLastName;
    
    this.spty.specialityName=val.spty;
    this.spty.doctor=this.dr;


    this.ht.hospitalName=val.hname;
    // alert("bedCount="+this.ht.bedCount);
   
     this.bedCount=val.bedCount;
     this.bedCount=this.bedCount-1;
     alert("bedCount="+this.bedCount);
      this.ht.bedCount=this.bedCount;
    
    
    this.ht.address=val.haddress;
    this.ht.speciality=this.spty;
    this.ht.roomCategory=this.rc;

    this.bk.startDate=this.dp.transform(val.picker1,"MM/dd/yyyy");
    
    this.bk.endDate=this.dp.transform(val.picker2,"MM/dd/yyyy");;
    
    
      this.bk.hospital=this.ht;
      this.bk.patient=this.pt;
      
      console.log(this.bk);
      
      
      this.bs.addBooking(this.bk).subscribe(
        success=>{
          console.log(success);
          this.bk=success;
          console.log("endDate="+success.endDate);
          
          this.receiptId=success.appointmentBookingId;
          alert("id="+this.receiptId);
          this.router.navigate(['/receipt'],{queryParams: { id : this.receiptId}});
        },
        error=>{
          console.log(error);
        }
      );
      
      // this.router.navigate(['/receipt'],{queryParams: { id : receiptId}});
      
      // this.router.navigate(['/receipt'],{queryParams: {id: 1}});
  }
    


  // addPatientReceipt(receipt:Receipt){
  //   console.log(receipt);
    
  // this.rs.addReceipt(receipt).subscribe(
  //     success=>{
  //       console.log(success);
  //       this.addedReceipt=success;
  //     },
  //     error=>{
  //       console.log(error);
  //     }
  //   );
  // }


  cleanForm() {
    this.appointmentForm.reset();
    alert("form cleanned");
  }

  getPatientDetails(ppid:number) {
    return this.s.getPatient(ppid).subscribe(
         success=>{
        alert("patient get")
        this.pt=success;
        console.log(this.pt);
        
        // this.receipt.patient=this.patient;
        // this.addPatientReceipt(this.receipt);
        // this.router.navigate([])
        // let receiptId=this.addedReceipt.receiptId;
        // this.router.navigate(['/appointment'],{queryParams: {hid: hospitalId,pid: patinetId}});
        
        
      },
       error=>{
        console.log(error);
      }
    );
  }

}
