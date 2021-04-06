import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry } from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { Estudiante } from '../../models/Estudiante/estudiante';

@Injectable({
  providedIn: 'root'
})
export class EstudianteService {

  url = environment.url + '/student';
  constructor(private http: HttpClient) { }

  create(e: Estudiante): Observable<Estudiante> {
    const estudianteBody = JSON.stringify(e);
    if (e.id === undefined){
      console.log(estudianteBody);
      return this.http.post<any>(`${this.url}/save`, estudianteBody, environment.httpOptions);
    }
    return this.http.put<any>(this.url, estudianteBody, environment.httpOptions);
  }

  retrieve(id: number): Observable<Estudiante> {
    return this.http.get<Estudiante>(`${this.url}/${id}`, environment.httpOptions)
      .pipe(retry(1));
  }

  delete(e: Estudiante): Observable<Estudiante> {
    return this.http.delete<any>(`${this.url}/delete/${e.id}`, environment.httpOptions);
  }

  list(): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(this.url, environment.httpOptions)
      .pipe(retry(1));
  }

}
