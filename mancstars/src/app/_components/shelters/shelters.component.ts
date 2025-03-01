import { NavbarComponent } from "../navbar/navbar.component";
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { provideHttpClient } from "@angular/common/http";
import { SheltersService } from '../../_services/shelters.service';

interface Shelter{
  shelterName: string;
  address: string;
  comment: string;
  directorName: string;
  email: string;
  phoneNumber: string;
  webAddress: URL;
}
@Component({
  selector: 'app-shelters',
  standalone: true,
  providers: [SheltersService],
  imports: [NavbarComponent, CommonModule,FormsModule],
  templateUrl: './shelters.component.html',
  styleUrl: './shelters.component.css'
})
export class SheltersComponent {
    constructor(private http: HttpClient, private sheltersServices: SheltersService) { }
      
      shelters: Shelter[] = [];
      selectedShelter: Shelter | null = null;
  
        ngOnInit() {
          // összes lofasz betöltése az apiból
          this.sheltersServices.getShelters().subscribe(data => {
            console.log('API válasz:', data);
            this.shelters = data.result;


          });
  }
     openPopup(shelter: Shelter) {
      this.selectedShelter = shelter;
    }

    closePopup() {
      this.selectedShelter = null;
    }
}
