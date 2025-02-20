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

}
