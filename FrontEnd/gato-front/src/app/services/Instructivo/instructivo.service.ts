import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry } from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { Instructivo } from '../../models/Instructivo/instructivo';

@Injectable({
  providedIn: 'root'
})
export class InstructivoService {

  url = environment.url + '/instructive';
  constructor(private http: HttpClient) { }

  create(i: Instructivo): Observable<Instructivo> {
    const instructivoBody = JSON.stringify(i);
    if (i.idInstructive === undefined){
      console.log(instructivoBody);
      return this.http.post<any>(`${this.url}/save`, instructivoBody, environment.httpOptions);
    }
    return this.http.put<any>(`${this.url}/update/${i.idInstructive}`, instructivoBody, environment.httpOptions);
  }

  retrieve(id: number): Observable<Instructivo> {
    return this.http.get<Instructivo>(`${this.url}/${id}`, environment.httpOptions)
      .pipe(retry(1));
  }

  delete(i: Instructivo): Observable<Instructivo> {
    return this.http.delete<any>(`${this.url}/delete/${i.idInstructive}`, environment.httpOptions);
  }

  list(): Observable<Instructivo[]> {
    return this.http.get<Instructivo[]>(this.url, environment.httpOptions)
      .pipe(retry(1));
  }
}
