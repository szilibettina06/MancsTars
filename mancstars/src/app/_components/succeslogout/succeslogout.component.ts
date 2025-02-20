import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-succeslogout',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './succeslogout.component.html',
  styleUrl: './succeslogout.component.css'
})
export class SucceslogoutComponent {
   currentRoute: string = '';
   constructor(private router: Router) {
    this.router.events.subscribe(() => {
      this.currentRoute = this.router.url;
    });
  }
  backToMainPage(): void{
    this.router.navigate(['/home']);
  }
}
