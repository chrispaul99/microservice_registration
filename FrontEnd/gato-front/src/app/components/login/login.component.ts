import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/Login/login.service';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import { Login } from '../../models/Usuario/Usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  admin: Login = new Login();
  form: FormGroup;
  submitted = false;

  constructor(
    private auth: LoginService,
    private formBuilder: FormBuilder,
  ) {}

  ngOnInit(): void {
    this.auth.sesionOpen();
    this.form = this.formBuilder.group({
      correo: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  onSubmit(): void {
    this.admin.password = 'espe2121';
    if (this.form.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error en el formulario',
      });
      return;
    }
    Swal.fire({
      allowOutsideClick: false,
      icon: 'info',
      text: 'Espere por favor...'
    });
    Swal.showLoading();
    this.auth.attachRuta(this.admin.username);
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
    this.submitted = true;
    this.onReset();
  }

  onReset(): void {
    this.submitted = false;
    this.admin = new Login();
    this.form.reset();
  }
}
