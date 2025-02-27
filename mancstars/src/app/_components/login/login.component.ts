import { Component } from '@angular/core';
import { LoginService } from '../../_services/login.service';
import { Router } from '@angular/router';
import { FormBuilder, FormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FormGroup } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { Validator } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ FormsModule,  CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent{
loginForm: FormGroup;
  errorMessage: string = "";
  isLoading: boolean = false;
  showPassword: boolean = false; 

  constructor(
    private fb: FormBuilder,
    private loginService: LoginService,
    private router: Router
  ){
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  onSubmit(): void{
    if(this.loginForm.valid){
      this.errorMessage = ''

      //Kinyerjük az űrlapból a felhasználnevet és a jelszót
      const{username, password} = this.loginForm.value;

      this.loginService.authenticate(username,password).subscribe({
        next: () => {
          this.router.navigate(['/dogs']); //Sikeres bejelentkezés esetén átírányít a főoldalra
        },
        error: (error) =>{
          this.errorMessage = error.message;
          this.isLoading = false; //Betöltés leállítása a hiba esetén
        },
        complete: () =>{
          this.isLoading = false; //A betöltési állapot visszaállítása, ha a folyamat véget ér
        }
      });
    } else{
      this.loginForm.markAllAsTouched();
    }
  }

  //A jelszó láthatóságának a beállítása
  togglePassword(): void{
    this.showPassword = !this.showPassword;
  }
  registerHere(): void{
    this.router.navigateByUrl('/signin');
  }
  forgotPassword(): void{
    this.router.navigate(['/enteremail']);
  }
}
