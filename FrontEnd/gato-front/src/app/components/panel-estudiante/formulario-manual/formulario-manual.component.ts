import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import { Formulario } from '../../../models/Formulario/formulario';

@Component({
  selector: 'app-formulario-manual',
  templateUrl: './formulario-manual.component.html',
  styleUrls: ['./formulario-manual.component.css']
})
export class FormularioManualComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  formulario: Formulario = new Formulario();

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
    this.formulario.status = false;
    // Obtener id del estudiante actual
    this.submitted = true;
    if (this.form.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error en el formulario',
      });
      return;
    }
    // this.periodoService.create(this.periodo).subscribe(() => {
    //   Swal.fire({
    //     position: 'top-end',
    //     icon: 'success',
    //     title: 'Periodo Agregada',
    //     showConfirmButton: false,
    //     timer: 1500
    //   });
    //   this.periodo = new Periodo();
    //   this.submitted = false;
    //   this.onReset();
    // });
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.formulario = new Formulario();
  }

}
