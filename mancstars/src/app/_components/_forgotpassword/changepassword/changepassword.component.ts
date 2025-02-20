import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FormGroup } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { Validator } from '@angular/forms';

@Component({
  selector: 'app-changepassword',
  standalone: true,
  imports: [FormsModule, CommonModule, ReactiveFormsModule],
  templateUrl: './changepassword.component.html',
  styleUrl: './changepassword.component.css'
})
export class ChangepasswordComponent {
   constructor(private router: Router) { }
  Change(): void{
    this.router.navigate(['/login']);
  }
}
