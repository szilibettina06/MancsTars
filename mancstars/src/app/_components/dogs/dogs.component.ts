
import { NavbarComponent } from "../navbar/navbar.component";
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { DogsService } from "../../_services/dogs.service";
import { Observable } from 'rxjs';
import { provideHttpClient } from "@angular/common/http";
import { ChangeDetectorRef } from "@angular/core";
import { Router } from "@angular/router";

interface Dog {
  gender: string;
  tendencyToGainWeight: number;
  health:number
  breed: string;
  playfulness: number;
  catFriendly: number
  intelligence: number
  tendencyToEscape: number;
  energyLevel: number;
  apartmentFriendly: number;
  dogImg: string;
  name: string;
  kidsFriendly: number;
  age: string;

}
@Component({
  selector: 'app-dogs',
  standalone: true,
  providers: [DogsService],
  imports: [NavbarComponent,CommonModule,FormsModule],
  templateUrl: './dogs.component.html',
  styleUrl: './dogs.component.css'
})
export class DogsComponent {
 constructor(private http: HttpClient, private dogsServices: DogsService, private router: Router) { }
  dogs: Dog[] = [];
  selectedDogs: Dog | null = null;
  ngOnInit() {
    // összes lofasz betöltése az apiból
    this.dogsServices.getDogs().subscribe(data => {
      console.log('API válasz:', data);
      this.dogs = data.result;  
    });
   
  }
  openPopup(dog: Dog) {
      this.selectedDogs = dog;
    }

    closePopup() {
      this.selectedDogs = null;
    }

  getStars(rating: number): string[] {
    if (rating === undefined || rating === null) {
    return []; 
  }
  return new Array(rating).fill('★').concat(new Array(5 - rating).fill('☆'));
}
  
}

