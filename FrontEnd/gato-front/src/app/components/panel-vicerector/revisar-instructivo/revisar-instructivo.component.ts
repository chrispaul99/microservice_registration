import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Instructivo } from '../../../models/Instructivo/instructivo';
import { InstructivoService } from '../../../services/Instructivo/instructivo.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-revisar-instructivo',
  templateUrl: './revisar-instructivo.component.html',
  styleUrls: ['./revisar-instructivo.component.css']
})
export class RevisarInstructivoComponent implements OnInit {

  pdfSrc = 'https://vadimdez.github.io/ng2-pdf-viewer/assets/pdf-test.pdf';
  instructivo: Instructivo = new Instructivo();

  constructor(
    private activatedRoute: ActivatedRoute,
    private instructivoService: InstructivoService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(
      params => {
        if (params.id){
          console.log(params.id);
          this.instructivoService.retrieve(params.id).subscribe(
            result => {
              this.instructivo = result;
            }
          );
        }
      }
    );
  }

  Denied(): void {
    this.instructivo.status = false;
    this.onSubmit('Denegado');
  }

  Aprobe(): void {
    this.instructivo.status = true;
    this.onSubmit('Aprobado');
  }

  onSubmit(str: string): void {
    this.instructivoService.create(this.instructivo).subscribe(() => {
      Swal.fire({
        position: 'top-end',
        icon: 'info',
        title: `Instructivo ${str}`,
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigateByUrl('/panelVicerector/Listar_Instructivos');
    });
  }

}
