import { DatePipe, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Booking } from 'src/app/classes/booking';
import { Doctor } from 'src/app/classes/doctor';
import { Hospital } from 'src/app/classes/hospital';
import { Patient } from 'src/app/classes/patient';
import { Receipt } from 'src/app/classes/receipt';
import { RoomCategory } from 'src/app/classes/room-category';
import { Speciality } from 'src/app/classes/speciality';
import { BookingService } from 'src/app/services/booking.service';
import { PatientService } from 'src/app/services/patient.service';
import { ReceiptService } from 'src/app/services/receipt.service';
import {  Inject,LOCALE_ID }  from '@angular/core';

@Component({
  selector: 'app-receipt',
  templateUrl: './receipt.component.html',
  styleUrls: ['./receipt.component.css']
})
export class ReceiptComponent implements OnInit {
  hospital = new Hospital();
  patient = new Patient();
  appBook = new Booking();
  sp = new Speciality();
  dt = new Doctor();
  rc = new RoomCategory();
  id = 0;
  totalFees = 0;
  hsName='';

  constructor(private ps: PatientService, private bs: BookingService, private route: ActivatedRoute,
    private dp:DatePipe
    ) {

    this.route.queryParams.subscribe(params => {
      this.id = params['id'];
      this.getBookingDetails(this.id);
    });
  }

  ngOnInit(): void {

  }


  getBookingDetails(id: number) {
    console.log("id=" + id);

    this.bs.getBooking(id).subscribe(
      success => {
        console.log(success);
        this.appBook = success;
        this.hospital = this.appBook.hospital;
        this.patient = this.appBook.patient;
        this.sp = this.hospital.speciality;
        this.dt = this.sp.doctor;
        this.rc = this.hospital.roomCategory;

        console.log("startDate="+this.appBook.startDate);

        let latest_start_date =this.appBook.startDate;
        let latest_end_date =this.appBook.endDate;
        
        console.log("latest_start_date="+latest_start_date);
        console.log("latest_end_date="+latest_end_date);
        

        var date1 = new Date(latest_start_date);
        var date2 = new Date(latest_end_date);

        var Time = date2.getTime() - date1.getTime();
        var Days = Time / (1000 * 3600 * 24); //Diference in Days
        alert("Days=" + Days);
        // if(Days > 0){
        this.totalFees = Days * this.rc.catRate;
        // alert("totalFees="+this.totalFees);  
        // }  

      },
      error => {
        console.log(error);
      }
    );
  }

}
