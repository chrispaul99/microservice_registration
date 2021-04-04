import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-revisar-instructivo',
  templateUrl: './revisar-instructivo.component.html',
  styleUrls: ['./revisar-instructivo.component.css']
})
export class RevisarInstructivoComponent implements OnInit {

  pdfSrc = 'https://vadimdez.github.io/ng2-pdf-viewer/assets/pdf-test.pdf';

  constructor(
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    // this.activatedRoute.params.subscribe(
    //   params => {
    //     if (params.id){
    //       this.alumnoService.retrieve(params.id).subscribe(
    //         result => {
    //           this.alumno = result;
    //         }
    //       );
    //     }
    //   }
    // );
  }

  Denied(): void {
    // False
    this.onSubmit();
  }

  Aprobe(): void {
    // True
    this.onSubmit();
  }

  onSubmit(): void {
    // if (this.form.invalid) {
    //   Swal.fire({
    //     icon: 'error',
    //     title: 'Oops...',
    //     text: 'Error en el formulario',
    //   });
    //   return;
    // }
    // this.materiaService.create(this.materia).subscribe(() => {
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
