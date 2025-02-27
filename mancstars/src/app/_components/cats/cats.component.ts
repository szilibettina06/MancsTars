import { Component } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";

@Component({
  selector: 'app-cats',
  standalone: true,
  imports: [NavbarComponent],
  templateUrl: './cats.component.html',
  styleUrl: './cats.component.css'
})
export class CatsComponent {
  baseUrl = "http://127.0.0.1:8080/Mancs_Tars-1.0-SNAP/webresources/cat/getAllCats";
}
