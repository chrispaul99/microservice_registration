import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubirInstructivoUarComponent } from './subir-instructivo-uar.component';

describe('SubirInstructivoUarComponent', () => {
  let component: SubirInstructivoUarComponent;
  let fixture: ComponentFixture<SubirInstructivoUarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubirInstructivoUarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubirInstructivoUarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
