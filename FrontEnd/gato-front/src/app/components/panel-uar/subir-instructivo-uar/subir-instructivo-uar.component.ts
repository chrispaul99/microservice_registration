import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Instructivo } from '../../../models/Instructivo/instructivo';
import { InstructivoService } from '../../../services/Instructivo/instructivo.service';
import { Administrador } from '../../../models/Administrador/administrador';

@Component({
  selector: 'app-subir-instructivo-uar',
  templateUrl: './subir-instructivo-uar.component.html',
  styleUrls: ['./subir-instructivo-uar.component.css']
})
export class SubirInstructivoUarComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  instructivo: Instructivo = new Instructivo();
  admin: Administrador = new Administrador();

  constructor(
    private formBuilder: FormBuilder,
    private instructivoService: InstructivoService,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      archivo: ['', [Validators.required]],
    });
    this.admin.idAdministrator = 1; /*Primero registrar en la BDD */
  }

  get f(){
    return this.form.controls;
  }

  onSubmit(): void {
    this.instructivo.administrator = this.admin;
    this.instructivo.status = true;
    this.submitted = true;
    if (this.form.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error en el formulario',
      });
      return;
    }
    this.instructivoService.create(this.instructivo).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Instructivo Enviado',
        showConfirmButton: false,
        timer: 1500
      });
      this.instructivo = new Instructivo();
      this.submitted = false;
      this.onReset();
    });
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.instructivo = new Instructivo();
  }

}
