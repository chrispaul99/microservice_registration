import { Component, OnInit } from '@angular/core';
// import { LoginService } from '../../services/Login/login.service';
import { Router } from '@angular/router'; // Borrar

@Component({
  selector: 'app-panel-director-carrera',
  templateUrl: './panel-director-carrera.component.html',
  styleUrls: ['./panel-director-carrera.component.css']
})
export class PanelDirectorCarreraComponent implements OnInit {

  nombres: string;
  constructor(private router: Router) {} // Borrar
  // constructor(private auth:LoginService) { }

  ngOnInit(): void {
    // const payLoad = JSON.parse(window.atob(localStorage.getItem('token').split('.')[1]));
    // this.nombres = `${payLoad.Apellidos} ${payLoad.Nombres}`;
    this.nombres = 'Carlitos Tévez';
  }
  logout(): void{
    // this.auth.logout();
    this.router.navigateByUrl('/Login'); // Borrar
  }

}
