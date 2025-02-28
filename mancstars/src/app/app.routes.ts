import { Routes } from '@angular/router';
import { HomeComponent } from './_components/home/home.component';
import { DogsComponent } from './_components/dogs/dogs.component';
import { CatsComponent } from './_components/cats/cats.component';
import { SheltersComponent } from './_components/shelters/shelters.component';
import { DetailsComponent } from './_components/details/details.component';
import { LoginComponent } from './_components/login/login.component';
import { SigninComponent } from './_components/signin/signin.component';
import { EnteremailComponent } from './_components/_forgotpassword/enteremail/enteremail.component';
import { VerifyComponent } from './_components/_forgotpassword/verify/verify.component';
import { ChangepasswordComponent } from './_components/_forgotpassword/changepassword/changepassword.component';
import { SucceslogoutComponent } from './_components/succeslogout/succeslogout.component';
import { AuthenticationGuard } from './_guards/auth.guard';
import { DogsPopupComponent } from './_components/dogs-popup/dogs-popup.component';


export const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'dogs', component: DogsComponent, canActivate: [AuthenticationGuard]  },
    { path: 'cats', component: CatsComponent },
    { path: 'shelters', component: SheltersComponent },
    { path: 'details', component: DetailsComponent },
    { path: 'login', component: LoginComponent },
    { path: 'signin', component: SigninComponent },
    { path: 'enteremail', component: EnteremailComponent },
    { path: 'verify', component: VerifyComponent },
    { path: 'changepassword', component: ChangepasswordComponent },
    { path: 'successlogout', component: SucceslogoutComponent },
    { path: 'dogspopup', component: DogsPopupComponent }
    
];
