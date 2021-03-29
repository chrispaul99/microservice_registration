import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Periodo } from '../../../models/Periodo/periodo';

@Component({
  selector: 'app-subir-cron-matriculas',
  templateUrl: './subir-cron-matriculas.component.html',
  styleUrls: ['./subir-cron-matriculas.component.css']
})
export class SubirCronMatriculasComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  periodo: Periodo = new Periodo();

  constructor(
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      archivo: ['', [Validators.required]],
    });
  }

  get f(){
    return this.form.controls;
  }

  onSubmit(): void {
    this.periodo.status = false;
    this.submitted = true;
    if (this.form.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error en el formulario',
      });
      return;
    }
    // this.empresaService.create(this.instructivo).subscribe(() => {
    //   Swal.fire({
    //     position: 'top-end',
    //     icon: 'success',
    //     title: 'Instructivo Enviado',
    //     showConfirmButton: false,
    //     timer: 1500
    //   });
    //   this.instructivo = new Instructivo();
    //   this.submitted = false;
    //   this.onReset();
    // });
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.periodo = new Periodo();
  }

}
