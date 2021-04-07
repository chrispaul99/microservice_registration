import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry } from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { Matricula } from '../../models/Matricula/matricula';

@Injectable({
  providedIn: 'root'
})
export class MatriculaService {

  url = environment.url + '/gestion/Registration';
  constructor(private http: HttpClient) { }

  create(m: Matricula): Observable<Matricula> {
    const matriculaBody = JSON.stringify(m);
    if (m.idRegistration === undefined){
      console.log(matriculaBody);
      return this.http.post<any>(`${this.url}/save`, matriculaBody, environment.httpOptions);
    }
    return this.http.put<any>(`${this.url}/update/${m.idRegistration}`, matriculaBody, environment.httpOptions);
  }

  retrieve(id: number): Observable<Matricula> {
    return this.http.get<Matricula>(`${this.url}/${id}`, environment.httpOptions)
      .pipe(retry(1));
  }

  delete(m: Matricula): Observable<Matricula> {
    return this.http.delete<any>(`${this.url}/delete/${m.idRegistration}`, environment.httpOptions);
  }

  list(): Observable<Matricula[]> {
    return this.http.get<Matricula[]>(this.url, environment.httpOptions)
      .pipe(retry(1));
  }
}
