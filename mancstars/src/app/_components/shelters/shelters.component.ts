import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-shelters',
  standalone: true,
  imports: [NavbarComponent],
  templateUrl: './shelters.component.html',
  styleUrl: './shelters.component.css'
})
export class SheltersComponent {
  baseUrl = "http://127.0.0.1:8080/Mancs_Tars-1.0-SNAP/webresources/shelter/getAllShelters";
}
