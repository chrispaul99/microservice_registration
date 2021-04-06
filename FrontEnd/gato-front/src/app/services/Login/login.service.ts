import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from '../../models/Usuario/Usuario';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url = environment.url + '/security/authjwt/signin';
  // url = 'http://localhost:8084/authjwt/signin';
  userToken: string;
  constructor(private http: HttpClient, private router: Router) {
    this.leerToken();
  }

  login(usuario: Login): Observable<Login> {
    const authData = {
      ...usuario,
      returnSecureToken: true
    };
    console.log(authData);
    return this.http.post<any>(this.url, authData, environment.httpOptions).pipe(
      map( resp => {
        this.guardarToken( resp.accessToken );
        console.log(resp);
        return resp;
      })
    );
  }

  leerToken(): string {

    if ( localStorage.getItem('token') ) {
      this.userToken = localStorage.getItem('token');
    } else {
      this.userToken = '';
    }

    return this.userToken;

  }
  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('expira');
    this.router.navigateByUrl('/Login');
  }
  private guardarToken( idToken: string ): void {

    this.userToken = idToken;
    localStorage.setItem('token', idToken);

    const hoy = new Date();
    hoy.setSeconds( 6000 );

    localStorage.setItem('expira', hoy.getTime().toString() );


  }
  estaAutenticado(): boolean {

    if ( this.userToken.length < 2 ) {
      return false;
    }

    const expira = Number(localStorage.getItem('expira'));
    const expiraDate = new Date();
    expiraDate.setTime(expira);

    if ( expiraDate > new Date() ) {
      return true;
    } else {
      this.logout();
      return false;
    }

  }
  roleMatch(allowedRoles): boolean {
    let isMatch = false;
    // const payLoad = JSON.parse(window.atob(localStorage.getItem('token').split('.')[1]));
    // console.log(payLoad);
    // const userRole = payLoad.rol;
    const userRole = 'A';
    console.log(userRole);
    allowedRoles.forEach(element => {
      if (userRole === element) {
        isMatch = true;
        return false;
      }
    });
    return isMatch;
  }
  verificarRol(): void {
    let rol = 'A'; /** Amage */
    // const payLoad = JSON.parse(window.atob(localStorage.getItem('token').split('.')[1]));
    // rol = payLoad.rol;
    switch (rol){
      case 'U':
        this.router.navigateByUrl('/panelEstudiante');
        break;
      case 'A':
        this.router.navigateByUrl('/panelDirector');
        break;
    }
  }

  sesionOpen(): void {
    if (this.estaAutenticado()){
      this.verificarRol();
    }
  }
}
