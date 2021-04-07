import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import { Periodo } from '../../../models/Periodo/periodo';
import { PeriodoService } from '../../../services/Periodo/periodo.service';
import { Instructivo } from '../../../models/Instructivo/instructivo';
import { InstructivoService } from '../../../services/Instructivo/instructivo.service';
import { Administrador } from '../../../models/Administrador/administrador';

@Component({
  selector: 'app-crear-periodo',
  templateUrl: './crear-periodo.component.html',
  styleUrls: ['./crear-periodo.component.css']
})
export class CrearPeriodoComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  periodo: Periodo = new Periodo();
  instructivos: Instructivo[] = [];
  instructivoSelected: number;
  admin: Administrador = new Administrador();

  constructor(
    private formBuilder: FormBuilder,
    private instructivoService: InstructivoService,
    private periodoService: PeriodoService
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      fechaInicio: ['', [Validators.required]],
      fechaFin: ['', [Validators.required]],
      instructivo: ['', [Validators.required]],
    });
    this.listarInstructivos();
    this.admin.idAdministrator = 1; /*Primero registrar en la BDD */
  }

  listarInstructivos(): void{
    this.instructivoService.list().subscribe(data => {
      console.log(data.length);
      for (let i = 0; i < data.length; i++) {
        console.log(`${i}: ${data[i].status}`);
        if (data[i].status) { this.instructivos.push(data[i]); }
      }
      if (this.instructivos.length === 0) {
        Swal.fire({
          icon: 'warning',
          title: 'Atención!',
          text: 'No existen instructivos aprobados',
        });
      }
    });
  }

  get f(){
    return this.form.controls;
  }

  attachInstructivo(id: number): void {
    this.instructivoService.retrieve(id).subscribe(rs => {
      this.periodo.instructive = rs;
      this.submitted = true;
      if (this.form.invalid) {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Error en el formulario',
        });
        return;
      }
      this.periodoService.create(this.periodo).subscribe(() => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Periodo Creado',
          showConfirmButton: false,
          timer: 1500
        });
        this.periodo = new Periodo();
        this.submitted = false;
        this.onReset();
      });
    });
  }

  onSubmit(): void {
    this.periodo.status = false;
    this.periodo.administrator = this.admin;
    this.attachInstructivo(this.instructivoSelected);
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.periodo = new Periodo();
  }

}
