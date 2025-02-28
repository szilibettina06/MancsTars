import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { DogsService } from "../../_services/dogs.service";
import { Observable } from 'rxjs';
import { provideHttpClient } from "@angular/common/http";
import { ChangeDetectorRef } from "@angular/core";
import { DogsComponent } from '../dogs/dogs.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dogs-popup',
  standalone: true,
  providers: [DogsService],
  imports: [CommonModule,FormsModule,],
  templateUrl: './dogs-popup.component.html',
  styleUrl: './dogs-popup.component.css'
})
export class DogsPopupComponent {
  constructor(private router: Router) { }
  
   closePopup():void {
     this.router.navigateByUrl('dogs')
  }
}
