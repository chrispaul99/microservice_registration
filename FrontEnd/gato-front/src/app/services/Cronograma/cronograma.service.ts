import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry } from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { Cronograma } from '../../models/Cronograma/cronograma';

@Injectable({
  providedIn: 'root'
})
export class CronogramaService {

  url = environment.url + '/gestion/schedule';
  constructor(private http: HttpClient) { }

  create(c: Cronograma): Observable<Cronograma> {
    const cronogramaBody = JSON.stringify(c);
    if (c.idSchedule === undefined){
      console.log(cronogramaBody);
      return this.http.post<any>(`${this.url}/save`, cronogramaBody, environment.httpOptions);
    }
    return this.http.put<any>(`${this.url}/update/${c.idSchedule}`, cronogramaBody, environment.httpOptions);
  }

  retrieve(id: number): Observable<Cronograma> {
    return this.http.get<Cronograma>(`${this.url}/${id}`, environment.httpOptions)
      .pipe(retry(1));
  }

  delete(c: Cronograma): Observable<Cronograma> {
    return this.http.delete<any>(`${this.url}/delete/${c.idSchedule}`, environment.httpOptions);
  }

  list(): Observable<Cronograma[]> {
    return this.http.get<Cronograma[]>(this.url, environment.httpOptions)
      .pipe(retry(1));
  }
}
