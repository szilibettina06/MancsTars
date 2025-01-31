import { Injectable } from '@angular/core';
interface User{
  username: string,
  password:string
}
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private adminLogin: User[] = [
    { username: 'mintapeter', password: 'almafa123'},
  ];

  private userLogin: User[] = [
    { username: 'mintalajos' , password: 'Almafa123'},
    
  ]

  constructor() { }

  adminLoginFunc(username: string, password: string): boolean {
    return this.adminLogin.some(admin => admin.username === username && admin.password === password);
  }

  userLoginFunc(username: string, password: string): boolean {
    if(this.userLogin.some(user => user.username === username && user.password === password)) {
      return true;
    }

    const users: User[] = JSON.parse(localStorage.getItem('users') || '[]');

    return users.some(user => user.username === username && user.password === password);
  }

}
