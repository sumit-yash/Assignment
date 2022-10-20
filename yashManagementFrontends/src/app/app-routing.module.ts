import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AdminComponent } from './components/admin/admin.component';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { HospitalComponent } from './components/hospital/hospital.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ReceiptComponent } from './components/receipt/receipt.component';
import { RegisterComponent } from './components/register/register.component';
import { SpecialityComponent } from './components/speciality/speciality.component';
import { UpdateComponent } from './components/update/update.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'admin',
    component: AdminComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'hospital',
    component: HospitalComponent
  },
  {
    path: 'speciality',
    component: SpecialityComponent
  },
  {
    path: 'update/:id',
    component: UpdateComponent
  },
  {
    path: 'appointment',
    component: AppointmentComponent
  },
  {
    path: 'receipt',
    component: ReceiptComponent
  }
  // {
  //   path: '**',
  //   component: PageNotFoundComponent
  // }
  

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
