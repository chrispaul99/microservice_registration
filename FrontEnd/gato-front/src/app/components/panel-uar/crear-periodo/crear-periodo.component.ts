import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import { Periodo } from '../../../models/Periodo/periodo';
import { Instructivo } from '../../../models/Instructivo/instructivo';

@Component({
  selector: 'app-crear-periodo',
  templateUrl: './crear-periodo.component.html',
  styleUrls: ['./crear-periodo.component.css']
})
export class CrearPeriodoComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  periodo: Periodo = new Periodo();
  instructivo: Instructivo = new Instructivo(); // Obtener del enviado

  constructor(
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      fechaInicio: ['', [Validators.required]],
      fechaFin: ['', [Validators.required]],
      descripcion: ['', [Validators.required]],
      status: ['', [Validators.required]],
      instructivo: ['', [Validators.required]],
    });
  }

  get f(){
    return this.form.controls;
  }

  onSubmit(): void {
    this.periodo.status = false;
    this.periodo.instructivo = this.instructivo;
    // this.periodo.cronograma = //Obtener archivo
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
    this.periodo = new Periodo();
  }

}
