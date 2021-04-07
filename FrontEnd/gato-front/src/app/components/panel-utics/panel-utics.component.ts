import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/Login/login.service';

@Component({
  selector: 'app-panel-utics',
  templateUrl: './panel-utics.component.html',
  styleUrls: ['./panel-utics.component.css']
})
export class PanelUticsComponent implements OnInit {

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
