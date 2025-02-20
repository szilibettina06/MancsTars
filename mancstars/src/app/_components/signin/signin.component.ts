import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signin',
  standalone: true,
  imports: [],
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.css'
})
export class SigninComponent {
  registerForm: FormGroup;
  errorMessage: string = '';
  successMessage: string = '';

  constructor(private fb: FormBuilder, private router: Router) {
    this.registerForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      const users = JSON.parse(localStorage.getItem('users') || '[]');

      // Ellenőrizzük, hogy a felhasználónév vagy az email már létezik-e
      const userExists = users.some((user: any) => 
        user.username === this.registerForm.value.username || user.email === this.registerForm.value.email
      );

      if (userExists) {
        this.errorMessage = 'A felhasználónév vagy az email már létezik!';
      } else {
        // Új felhasználó hozzáadása a listához
        users.push(this.registerForm.value);
        localStorage.setItem('users', JSON.stringify(users));

        this.successMessage = 'Sikeres regisztráció! Most bejelentkezhetsz.';
        this.errorMessage = '';

        // Átirányítás 2 másodperc múlva
        setTimeout(() => this.router.navigate(['/login']), 2000);
      }
    }
  }
  loginHere(): void{
    this.router.navigate(['/login']);
  }

  //   this.errorMessage = '';

  //   const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  //   const passRegex = /^(?!.*[s])(?=.*[A-Z])(?=.*\d).{8,24}$/;

  //   if (!this.registerUsername || !this.registerEmail || !this.registerPass || !this.registerCPass || !this.registerBDate) {
  //     this.errorMessage = 'Please fill in all fields!';
  //     return;
  //   }

  //   if (!emailRegex.test(this.registerEmail)) {
  //     this.errorMessage = 'Invalid email adress!';
  //     return;
  //   }

  //   if (!passRegex.test(this.registerPass)) {
  //     this.errorMessage = `Invalid password.
  //     Password must be 8-24 characters long,
  //     contain at least one uppercase letter,
  //     one number, and have no spaces.`;
  //     return;
  //   }

  //   if (this.registerPass !== this.registerCPass) {
  //     this.errorMessage = 'Passwords do not match!';
  //     return;
  //   }

  //   const parsedBDate = new Date(this.registerBDate);
  //   if (isNaN(parsedBDate.getTime()) || parsedBDate >= this.registerService.minDate) {
  //     this.errorMessage = 'You are too young to play this game!';
  //     return;
  //   }

  //   const isRegistered = this.registerService.registerFunc(
  //     this.registerUsername,
  //     this.registerEmail,
  //     this.registerPass,
  //     this.registerCPass,
  //     parsedBDate
  //   );

  //   if (isRegistered) {
  //     const users = JSON.parse(localStorage.getItem('users') || '[]');
  //     users.push({
  //       username: this.registerUsername,
  //       email: this.registerEmail,
  //       password: this.registerPass
  //     });

  //     localStorage.setItem('users', JSON.stringify(users));

  //     this.registerUsername = '';
  //     this.registerEmail = '';
  //     this.registerPass = '';
  //     this.registerCPass = '';
  //     this.registerBDate = '';

  //     alert('Registration successful!');
  //   } else {
  //     this.errorMessage = 'Invalid username, email or password!';
  //   }
  //   this.r
  // }
}
