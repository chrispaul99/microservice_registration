import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry } from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { Persona } from '../../models/Persona/Persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  url = environment.url + '/Personas';
  constructor(private http: HttpClient) { }

  create(p: Persona): Observable<Persona> {
    const personaBody = JSON.stringify(p);
    if (p.ID === undefined){
      return this.http.post<any>(this.url, personaBody, environment.httpOptions);
    }
    return this.http.put<any>(this.url, personaBody, environment.httpOptions);
  }

  retrieve(id: string): Observable<Persona> {
    return this.http.get<Persona>(this.url + '/' + id, environment.httpOptions)
      .pipe(retry(1));
  }

  delete(p: Persona): Observable<Persona> {
    return this.http.delete<any>(this.url + '/' + p.ID, environment.httpOptions);
  }

  list(): Observable<Persona[]> {
    return this.http.get<Persona[]>(this.url, environment.httpOptions)
      .pipe(retry(1));
  }
}
