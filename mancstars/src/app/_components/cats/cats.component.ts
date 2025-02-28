import { NavbarComponent } from "../navbar/navbar.component";
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CatsService } from '../../_services/cats.service';
import { provideHttpClient } from "@angular/common/http";

@Component({
  selector: 'app-cats',
  standalone: true,
  providers:[CatsService],
  imports: [NavbarComponent,FormsModule, CommonModule],
  templateUrl: './cats.component.html',
  styleUrl: './cats.component.css'
})
export class CatsComponent {
  constructor(private http: HttpClient, private catsServices: CatsService) { }
    
    cats: any[] = [];
    
  ngOnInit() {
    // összes lofasz betöltése az apiból
    this.catsServices.getCats().subscribe(data => {
      console.log('API válasz:', data);
      this.cats = data.result;
      
      
    });
  }
    
}
