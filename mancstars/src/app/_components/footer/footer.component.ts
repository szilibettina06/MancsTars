import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  email: string = 'mancstars@gmail.com';
  phonenumber: string = '+36 30 322 4344';
}
