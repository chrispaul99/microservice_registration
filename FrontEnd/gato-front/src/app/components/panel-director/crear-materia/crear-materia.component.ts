import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import { Materia } from '../../../models/Materia/materia';
import { MateriaService } from '../../../services/Materia/materia.service';

@Component({
  selector: 'app-crear-materia',
  templateUrl: './crear-materia.component.html',
  styleUrls: ['./crear-materia.component.css']
})
export class CrearMateriaComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  materia: Materia = new Materia();

  constructor(
    private formBuilder: FormBuilder,
    private materiaService: MateriaService,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      carrera: ['', [Validators.required]],
      nivel: ['', [Validators.required]],
      nrc: ['', [Validators.required]],
      creditos: ['', [Validators.required]],
    });
  }

  get f(){
    return this.form.controls;
  }

  onSubmit(): void {
    this.materia.status = false;
    this.submitted = true;
    if (this.form.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error en el formulario',
      });
      return;
    }
    this.materiaService.create(this.materia).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Materia Agregada',
        showConfirmButton: false,
        timer: 1500
      });
      this.materia = new Materia();
      this.submitted = false;
      this.onReset();
    });
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
    this.materia = new Materia();
  }

}
