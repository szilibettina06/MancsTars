import { NavbarComponent } from "../navbar/navbar.component";
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CatsService } from '../../_services/cats.service';
import { provideHttpClient } from "@angular/common/http";

interface Cat {
  gender: string;
  tendencyToGainWeight: number;
  health:number
  breed: string;
  playfulness: number;
  dogFriendly: number
  intelligence: number
  tendencyToEscape: number;
  energyLevel: number;
  apartmentFriendly: number;
  catImg: string;
  name: string;
  kidsFriendly: number;
  age: string;

}

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
    
    cats: Cat[] = [];
    selectedCats: Cat | null = null;
  ngOnInit() {
    // összes lofasz betöltése az apiból
    this.catsServices.getCats().subscribe(data => {
      console.log('API válasz:', data);
      this.cats = data.result;
      
      
    });
  }
   openPopup(cat: Cat) {
      this.selectedCats = cat;
    }

    closePopup() {
      this.selectedCats = null;
    }
    
}
