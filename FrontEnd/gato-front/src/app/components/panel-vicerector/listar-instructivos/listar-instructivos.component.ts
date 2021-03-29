import { Component, OnInit } from '@angular/core';
import { Instructivo } from '../../../models/Instructivo/instructivo';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-instructivos',
  templateUrl: './listar-instructivos.component.html',
  styleUrls: ['./listar-instructivos.component.css']
})
export class ListarInstructivosComponent implements OnInit {

  instructivo: Instructivo = new Instructivo();
  instructivos: Instructivo[];

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.listarInstructivos();
  }

  listarInstructivos(): void{
    // this.empresaService.list().subscribe(data => {
    //   this.empresas = data;
    // });
  }

  cargarData(id: number): void {
    this.router.navigateByUrl(`/panelVicerector/${id}`);
  }

}
