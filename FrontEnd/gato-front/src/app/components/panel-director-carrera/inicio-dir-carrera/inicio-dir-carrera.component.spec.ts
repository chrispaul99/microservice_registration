import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioDirCarreraComponent } from './inicio-dir-carrera.component';

describe('InicioDirCarreraComponent', () => {
  let component: InicioDirCarreraComponent;
  let fixture: ComponentFixture<InicioDirCarreraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InicioDirCarreraComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InicioDirCarreraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
