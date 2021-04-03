import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import { Materia } from '../../../models/Materia/materia';

@Component({
  selector: 'app-listar-materias',
  templateUrl: './listar-materias.component.html',
  styleUrls: ['./listar-materias.component.css']
})
export class ListarMateriasComponent implements OnInit {

  materia: Materia = new Materia();
  materias: Materia[];
  form: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      carrera: ['', [Validators.required]],
      nivel: ['', [Validators.required]],
      nrc: ['', [Validators.required]],
      creditos: ['', [Validators.required]],
    });
    this.listarMaterias();
  }

  get f(){
    return this.form.controls;
  }

  listarMaterias(): void{
    // this.empresaService.list().subscribe(data => {
    //   this.empresas = data;
    // });
  }

  eliminar(m: Materia): void {
    Swal.fire({
      title: '¿Estás seguro?',
      text: 'Se eliminará la materia.',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar',
      cancelButtonText: 'Cancelar!'
    }).then((result) => {
      if (result.isConfirmed) {
        // this.empresaService.delete(m).subscribe(() => {
        //   Swal.fire(
        //     'Borrado!',
        //     'La materia fue eliminada.',
        //     'success'
        //   );
        //   this.listarMaterias();
        // });
      }
    });
  }

  cargarData(id: number): void {
    // this.empresaService.retrieve(id).subscribe(data => {
    //   this.materia = data;
    // }, (error) => console.log(error),
    // () => {
    //   this.listarMaterias();
    // });
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.form.invalid) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error en el formulario',
      });
      return;
    }
    // this.empresaService.create(this.materia).subscribe(() => {
    //   Swal.fire({
    //     position: 'top-end',
    //     icon: 'success',
    //     title: 'Materia Modificada',
    //     showConfirmButton: false,
    //     timer: 1500
    //   });
    //   this.materia = new Materia();
    //   this.submitted = false;
    //   location.reload();
    // });
  }

}
