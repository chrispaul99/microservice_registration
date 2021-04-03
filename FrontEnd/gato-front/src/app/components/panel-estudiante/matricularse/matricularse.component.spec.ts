import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatricularseComponent } from './matricularse.component';

describe('MatricularseComponent', () => {
  let component: MatricularseComponent;
  let fixture: ComponentFixture<MatricularseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatricularseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatricularseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
