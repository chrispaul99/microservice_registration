import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/Login/login.service';

@Component({
  selector: 'app-panel-uar',
  templateUrl: './panel-uar.component.html',
  styleUrls: ['./panel-uar.component.css']
})
export class PanelUarComponent implements OnInit {

  nombres: string;
  constructor(private auth: LoginService) { }

  ngOnInit(): void {
    // const payLoad = JSON.parse(window.atob(localStorage.getItem('token').split('.')[1]));
    // this.nombres = `${payLoad.Apellidos} ${payLoad.Nombres}`;
    this.nombres = 'Carlitos Tévez';
  }

  logout(): void{
    this.auth.logout();
  }

}
