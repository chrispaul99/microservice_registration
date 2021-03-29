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

  Denied(): void {}

  Aprobe(): void {}

}
