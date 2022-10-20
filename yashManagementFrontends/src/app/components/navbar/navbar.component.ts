import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/classes/patient';
import { LoginService } from 'src/app/services/login.service';
import { LoginComponent } from '../login/login.component';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  // [x: string]: any;
  // public sessionStorage = sessionStorage;
  isValid:boolean=false;
  // name=this.sessionStorage.getItem('name');
  login=LoginService;
  data:string='';
  
  
  

  constructor(private route:ActivatedRoute,private router: Router) {
   
    // console.log("stringify="+
    //  JSON.stringify(sessionStorage.getItem('patient'))
    //  );

  }

  ngOnInit(): void {
    // if (this.router.snapshot.params['response'] != undefined ) {
      // alert("navbar patient="+JSON.parse(this.router.snapshot.params['response']));
    // }
    // console.log("session obj at navbar="+sessionStorage.getItem('patient'));

    // this.route.queryParamMap.subscribe(params => this.patient = params.getAll('words'));
    
    if(sessionStorage.getItem('patient') != null){
      console.log("navbar session data="+sessionStorage.getItem('patient'));     
      this.isValid=true;
    }else{
      this.isValid=false;
    }
  }

  logout(){
    sessionStorage.clear();
    this.router.navigateByUrl("/login");
  }



}
