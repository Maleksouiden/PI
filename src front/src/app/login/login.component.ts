import { Component } from '@angular/core';
import { SharedService } from '../services/shared.service';
import { DataServicesService } from './../services/data-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  email: string | undefined;
  password: string | undefined;

  constructor(
    private router: Router,
    private sharedService: SharedService,
    private dataServicesService: DataServicesService
  ) {}

  login() {
    if (!this.email || !this.password) {
      console.error('Please enter the email and password');
      return;
    }

    this.dataServicesService.getUser().subscribe(
      (users: any) => {
        const user = users.find((u: any) => u.login_utilisateur === this.email);

        if (user) {
          if (user.password_utilisateur === this.password) {
            console.log('Login successful!');
            this.sharedService.setMyVariable(user.id_utilisateur);
            const variable = this.sharedService.getMyVariable();
            console.log(variable);
            this.dataServicesService.getUserco(user.id_utilisateur);
            this.router.navigate(['/annonces']);
          } else {
            console.error('Incorrect password');
          }
        } else {
          console.error('User not found');
        }
      },
      (error) => {
        console.error('An error occurred while retrieving users', error);
      }
    );
  }

  getVariableValue() {
    const variable = this.sharedService.getMyVariable();
    console.log(variable);
  }
}
function routerLink(arg0: string[]) {
  throw new Error('Function not implemented.');
}
