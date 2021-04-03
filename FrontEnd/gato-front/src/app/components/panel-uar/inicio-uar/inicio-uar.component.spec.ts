import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioUarComponent } from './inicio-uar.component';

describe('InicioUarComponent', () => {
  let component: InicioUarComponent;
  let fixture: ComponentFixture<InicioUarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InicioUarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InicioUarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
