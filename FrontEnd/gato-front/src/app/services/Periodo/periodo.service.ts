import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry } from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { Periodo } from '../../models/Periodo/periodo';
import { Cronograma } from '../../models/Cronograma/cronograma';

@Injectable({
  providedIn: 'root'
})
export class PeriodoService {

  url = environment.url + '/gestion/period';
  // url = 'http://localhost:8082/period';
  constructor(private http: HttpClient) { }

  create(p: Periodo): Observable<Periodo> {
    const periodoBody = JSON.stringify(p);
    if (p.idPeriod === undefined){
      console.log(periodoBody);
      return this.http.post<any>(`${this.url}/save`, periodoBody, environment.httpOptions);
    }
    return this.http.put<any>(`${this.url}/update/${p.idPeriod}`, periodoBody, environment.httpOptions);
  }

  createSchedule(id: number, schedule: Cronograma): Observable<Periodo> {
    const periodoBody = JSON.stringify(schedule);
    return this.http.put<any>(`${this.url}/schedule/${id}`, periodoBody, environment.httpOptions);
  }

  retrieve(id: number): Observable<Periodo> {
    return this.http.get<Periodo>(`${this.url}/${id}`, environment.httpOptions)
      .pipe(retry(1));
  }

  delete(p: Periodo): Observable<Periodo> {
    return this.http.delete<any>(`${this.url}/delete/${p.idPeriod}`, environment.httpOptions);
  }

  list(): Observable<Periodo[]> {
    return this.http.get<Periodo[]>(this.url, environment.httpOptions)
      .pipe(retry(1));
  }
}
