import { Component, OnInit } from '@angular/core';
import { Instructivo } from '../../../models/Instructivo/instructivo';
import { InstructivoService } from '../../../services/Instructivo/instructivo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-instructivos',
  templateUrl: './listar-instructivos.component.html',
  styleUrls: ['./listar-instructivos.component.css']
})
export class ListarInstructivosComponent implements OnInit {

  instructivo: Instructivo = new Instructivo();
  instructivos: Instructivo[];

  constructor(private router: Router, private instructivoService: InstructivoService) { }

  ngOnInit(): void {
    this.listarInstructivos();
  }

  listarInstructivos(): void{
    this.instructivoService.list().subscribe(data => {
      this.instructivos = data;
    });
  }

  cargarData(id: number): void {
    this.router.navigateByUrl(`/panelVicerector/Revisar/${id}`);
  }

}
