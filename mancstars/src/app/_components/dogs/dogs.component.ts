import { Component } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";

@Component({
  selector: 'app-dogs',
  standalone: true,
  imports: [NavbarComponent],
  templateUrl: './dogs.component.html',
  styleUrl: './dogs.component.css'
})
export class DogsComponent {

}
