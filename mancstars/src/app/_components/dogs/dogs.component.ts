
import { NavbarComponent } from "../navbar/navbar.component";
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { DogsService } from "../../_services/dogs.service";

import { Observable } from 'rxjs';

@Component({
  selector: 'app-dogs',
  standalone: true,
  imports: [NavbarComponent,CommonModule,FormsModule,],
  templateUrl: './dogs.component.html',
  styleUrl: './dogs.component.css'
})
export class DogsComponent {
 constructor(private dogsService:DogsComponent, private http: HttpClient) { }
  
  // karakterek listája
  dogs$: Observable<Array<{ id: string; name: string }>> | undefined;
  
  ngOnInit() {
    // összes lofasz betöltése az apiból
    this.dogs$ = this.dogsService.getDogs();
    // adott lofasz és adtaok lekérése
    
  }
}

