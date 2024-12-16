import { Routes } from '@angular/router';
import { HomeComponent } from './_components/home/home.component';
import { DogsComponent } from './_components/dogs/dogs.component';
import { CatsComponent } from './_components/cats/cats.component';
import { SheltersComponent } from './_components/shelters/shelters.component';
import { DetailsComponent } from './_components/details/details.component';


export const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'dogs', component: DogsComponent },
    { path: 'cats', component: CatsComponent },
    { path: 'shelters', component: SheltersComponent },
    { path: 'details', component: DetailsComponent }
];
