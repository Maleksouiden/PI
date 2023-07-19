import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ReclamationsComponent } from './reclamations/reclamations.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AnonceDetailsComponent } from './anonce-details/anonce-details.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SharedService } from './services/shared.service';

const ROUTERS: Routes = [
  { path: 'annonces', component: HomePageComponent },
  { path: 'reclamation', component: ReclamationsComponent },
  { path: 'annonces/:id', component: AnonceDetailsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', component: LoginComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ReclamationsComponent,
    NavbarComponent,
    AnonceDetailsComponent,
    LoginComponent,
    RegisterComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(ROUTERS),
  ],
  providers: [SharedService],
  bootstrap: [AppComponent],
})
export class AppModule {}
