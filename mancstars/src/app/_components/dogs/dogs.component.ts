
import { NavbarComponent } from "../navbar/navbar.component";
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { DogsService } from "../../_services/dogs.service";
import { Observable } from 'rxjs';
import { provideHttpClient } from "@angular/common/http";


@Component({
  selector: 'app-dogs',
  standalone: true,
  providers: [DogsService],
  imports: [NavbarComponent,CommonModule,FormsModule],
  templateUrl: './dogs.component.html',
  styleUrl: './dogs.component.css'
})
export class DogsComponent {
 constructor(private http: HttpClient, private dogsServices: DogsService) { }
  
  dogs: any[] = [];
  ngOnInit() {
    // összes lofasz betöltése az apiból
    this.dogsServices.getDogs().subscribe(data => {
      console.log('API válasz:', data);
      this.dogs = data.result;  
    });
    
    
  }
  
  
  
}

