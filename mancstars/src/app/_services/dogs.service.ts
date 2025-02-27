import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, switchMap, map } from 'rxjs';

// karakter adataihoz kell az interfész
interface Dog {
  name: string;
  age: string;
  gender: string;
  breed: string;
  dogImg: URL;


}
// karakter válasz
interface DogApiResponse {
  result: {
    properties: Dog;

  }
}


// karakterek listájához
interface DogResponse {
  result: Array<{ id: string; name: string }>

}

@Injectable({
  providedIn: 'root'
})
export class DogsService {

  // lehetövé teszi számunkra a http kérések küldését
  constructor(private http: HttpClient) { }
  private readonly API_URL = "http://127.0.0.1:8080/Mancs_Tars-1.0-SNAP/webresources/dog/getAllDogs";
  getDogs(): Observable<Array<{ id: string; name: string }>> {
    return this.http.get<DogResponse>(`${this.API_URL}`)
      .pipe(
        map(response => response.result.map(dog => ({
          id: dog.id,
          name: dog.name
        })))
      );
  }
  getDog(id: string): Observable<any> {
    return this.http.get<DogApiResponse>(`${this.API_URL}/${id}`)
      .pipe(
        switchMap(dogResponse => {
          const dog = dogResponse.result.properties;
          return this.http.get<DogApiResponse>(dog.name);
        })
      );
  }
}
