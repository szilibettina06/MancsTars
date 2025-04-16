import { Injectable } from '@angular/core';
import { Observable,of, throwError } from 'rxjs';
import { Router } from '@angular/router';

interface User{
  username: string,
  password:string
}
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private router: Router) { }

     //A beégetett felhasználónév beállítása
  private readonly VALID_USERNAME = 'user';
  //A beégetett jelszó beállítása
  private readonly VALID_PASSWORD = '1234';

  authenticate(username: string, password:string):Observable<boolean>{
    if(username === this.VALID_USERNAME && password ===this.VALID_PASSWORD){
      localStorage.setItem('isLoggedIn','true');
      this.router.navigate(['/home']);
      return of(true);
    }
    return throwError(() => new Error('Hibás felhasználónév vagy jelszó'));
  }

  //Ellenőrzés, hogy a felhasználó be van e jelentkezve
  isLoggedIn(): boolean{
    return localStorage.getItem('isLoggedIn') === 'true';
  }

  logout(): void{
    localStorage.removeItem('isLoggedIn');
    this.router.navigate(['/login']);
  }

}
