import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry } from 'rxjs/operators';
import { environment } from '../../../environments/environment.prod';
import { Usuario } from '../../models/Usuario/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  url = environment.url + '/Usuarios';
  constructor(private http: HttpClient) { }

  create(p: Usuario): Observable<Usuario> {
    const UsuarioBody = JSON.stringify(p);
    if (p.ID === undefined){
      return this.http.post<any>(this.url, UsuarioBody, environment.httpOptions);
    }
    return this.http.put<any>(this.url, UsuarioBody, environment.httpOptions);
  }

  retrieve(id: string): Observable<Usuario> {
    return this.http.get<Usuario>(this.url + '/' + id, environment.httpOptions)
      .pipe(retry(1));
  }

  delete(p: Usuario): Observable<Usuario> {
    return this.http.delete<any>(this.url + '/' + p.ID, environment.httpOptions);
  }

  list(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.url, environment.httpOptions)
      .pipe(retry(1));
  }
}
