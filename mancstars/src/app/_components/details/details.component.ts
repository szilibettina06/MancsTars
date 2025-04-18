import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from "../footer/footer.component";


@Component({
  selector: 'app-details',
  standalone: true,
  imports: [NavbarComponent, FooterComponent],
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent {
  email: string = 'mancstars@gmail.com';
  phonenumber: string = '+36 30 322 4344';
}
