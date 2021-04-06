import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/Login/login.service';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
// import { EncryptService } from '../../services/Encrypt/encrypt.service';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
import { Login } from '../../models/Usuario/Usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // constructor(private router: Router) {} // Borrar

  admin: Login = new Login();
  form: FormGroup;
  submitted = false;

  constructor(
    private auth: LoginService,
    // private formBuilder: FormBuilder,
  ) {}

  ngOnInit(): void {

    this.auth.sesionOpen();
  }
  login( form: NgForm ): void {
  // this.form = this.formBuilder.group({
  //   correo: ['', [Validators.required]],
  //   password: ['', [Validators.required]],
  // });
  // if (  form.invalid ) { return; }

    /* administrador*/
  this.admin.username = 'espe2121';
  this.admin.password = 'espe2121';

    /* usuario*/
    /*this.usuario.ID = 'L00379361';
    this.usuario.password = '6zmKXdL2OJMAlFWSTIJcbQ==';*/
  Swal.fire({
    allowOutsideClick: false,
    icon: 'info',
    text: 'Espere por favor...'
  });
  Swal.showLoading();

    /*var encrypted = this.EncrDecr.set('123456$#@$^@1ERF', this.usuario.password);
    console.log(encrypted);
    this.usuario.password = encrypted;*/

  this.auth.login( this.admin )
    .subscribe( resp => {
      this.auth.verificarRol();
      Swal.close();
    }, (err) => {
      console.log(err);
      Swal.fire({
        icon: 'error',
        title: 'Error al autenticar',
        text: 'Inténtelo de nuevo'
      });
    });
  }
}
