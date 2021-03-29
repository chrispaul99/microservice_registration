import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizarMateriaComponent } from './actualizar-materia.component';

describe('ActualizarMateriaComponent', () => {
  let component: ActualizarMateriaComponent;
  let fixture: ComponentFixture<ActualizarMateriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizarMateriaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarMateriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
