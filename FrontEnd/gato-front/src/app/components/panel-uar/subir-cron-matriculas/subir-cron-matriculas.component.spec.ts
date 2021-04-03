import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubirCronMatriculasComponent } from './subir-cron-matriculas.component';

describe('SubirCronMatriculasComponent', () => {
  let component: SubirCronMatriculasComponent;
  let fixture: ComponentFixture<SubirCronMatriculasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubirCronMatriculasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubirCronMatriculasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
