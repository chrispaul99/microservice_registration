import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry } from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { Materia } from '../../models/Materia/materia';

@Injectable({
  providedIn: 'root'
})
export class MateriaService {

  url = environment.url + '/subject';
  constructor(private http: HttpClient) { }

  create(m: Materia): Observable<Materia> {
    const materiaBody = JSON.stringify(m);
    if (m.idSubject === undefined){
      console.log(materiaBody);
      return this.http.post<any>(`${this.url}/save`, materiaBody, environment.httpOptions);
    }
    return this.http.put<any>(`${this.url}/update/${m.idSubject}`, materiaBody, environment.httpOptions);
  }

  retrieve(id: number): Observable<Materia> {
    return this.http.get<Materia>(`${this.url}/${id}`, environment.httpOptions)
      .pipe(retry(1));
  }

  delete(m: Materia): Observable<Materia> {
    return this.http.delete<any>(`${this.url}/delete/${m.idSubject}`, environment.httpOptions);
  }

  list(): Observable<Materia[]> {
    return this.http.get<Materia[]>(this.url, environment.httpOptions)
      .pipe(retry(1));
  }
}
