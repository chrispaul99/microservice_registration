import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioManualComponent } from './formulario-manual.component';

describe('FormularioManualComponent', () => {
  let component: FormularioManualComponent;
  let fixture: ComponentFixture<FormularioManualComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormularioManualComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioManualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
