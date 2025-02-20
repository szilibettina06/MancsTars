import { Router, CanActivate } from '@angular/router';
import { LoginService } from '../_services/login.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'

})
export class AuthenticationGuard implements CanActivate {
  constructor(private loginService: LoginService, private router: Router) { }

  canActivate(): boolean {
    if (this.loginService.isLoggedIn()) {
      return true;
    }
    this.router.navigate(['/dogs']);
    return false;
  }
}
