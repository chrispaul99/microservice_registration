import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Formulario } from '../../../models/Formulario/formulario';

@Component({
  selector: 'app-listar-formularios',
  templateUrl: './listar-formularios.component.html',
  styleUrls: ['./listar-formularios.component.css']
})
export class ListarFormulariosComponent implements OnInit {

  formulario: Formulario = new Formulario();
  formularios: Formulario[];

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.listarFormularios();
  }

  listarFormularios(): void{
    // this.empresaService.list().subscribe(data => {
    //   this.empresas = data;
    // });
  }

  cargarData(id: number): void {
    this.router.navigateByUrl(`/Autorizar_Matricula/${id}`);
  }

}
