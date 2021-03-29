import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorizarMatriculaComponent } from './autorizar-matricula.component';

describe('AutorizarMatriculaComponent', () => {
  let component: AutorizarMatriculaComponent;
  let fixture: ComponentFixture<AutorizarMatriculaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AutorizarMatriculaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorizarMatriculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
