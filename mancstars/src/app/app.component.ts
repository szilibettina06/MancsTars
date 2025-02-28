import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NavigationEnd } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule,HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'mancstars';

  backgroundClass: string = '';
  constructor(private router: Router) { }
  ngOnInit(): void {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        if (event.url === '/' || event.url.startsWith('/home')) {
          this.backgroundClass = 'mainPage';
        } else if (event.url.startsWith('/dogs') || event.url.startsWith('/cats') || event.url.startsWith('/shelters') || event.url.startsWith('/details')) {
          this.backgroundClass = 'bg';
        }
      }
    })
  }
}
