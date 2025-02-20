import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FormGroup } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { Validator } from '@angular/forms';

@Component({
  selector: 'app-enteremail',
  standalone: true,
  imports: [FormsModule, CommonModule, ReactiveFormsModule],
  templateUrl: './enteremail.component.html',
  styleUrl: './enteremail.component.css'
})
export class EnteremailComponent {
  constructor(private router: Router) { }

  continue(): void{
    this.router.navigate(['/verify'])
  }
}
