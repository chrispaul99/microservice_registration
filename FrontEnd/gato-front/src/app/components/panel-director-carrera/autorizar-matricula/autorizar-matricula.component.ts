import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-autorizar-matricula',
  templateUrl: './autorizar-matricula.component.html',
  styleUrls: ['./autorizar-matricula.component.css']
})
export class AutorizarMatriculaComponent implements OnInit {

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
