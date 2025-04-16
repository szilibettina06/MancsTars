import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, switchMap, map } from 'rxjs';





@Injectable({
  providedIn: 'root'
})
export class DogsService {

  // lehetövé teszi számunkra a http kérések küldését
  constructor(private http: HttpClient) { }
  private readonly API_URL = "http://127.0.0.1:8080/Mancs_Tars-1.0-SNAP/webresources/dog/getAllDogs";
  getDogs(): Observable<any>{
    return this.http.get<any>(this.API_URL);
  }
}
