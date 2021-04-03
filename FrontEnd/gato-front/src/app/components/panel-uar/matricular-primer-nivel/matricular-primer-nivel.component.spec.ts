import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatricularPrimerNivelComponent } from './matricular-primer-nivel.component';

describe('MatricularPrimerNivelComponent', () => {
  let component: MatricularPrimerNivelComponent;
  let fixture: ComponentFixture<MatricularPrimerNivelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatricularPrimerNivelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatricularPrimerNivelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
