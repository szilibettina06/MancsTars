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
  private readonly VALID_USERNAME = ' admin';
  private readonly VALID_PASSWORD = '1234';

  authenticate(username: string, password: string): Observable<boolean>{
    if (username===this.VALID_USERNAME && password===this.VALID_PASSWORD) {
      localStorage.setItem('isLoggedIn', 'true');
      this.router.navigate(['/dogs']);
      return of(true);
    }
    return throwError(() => new Error('Hibás felhasználonév vagy jelszó'));

  }
  isLoggedIn(): boolean{
    return !localStorage.getItem('isLoggedIn');
  }
  logout(): void{
    localStorage.removeItem('isLoggedIn');
    this.router.navigate(['/login']);
  }

}
