import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioVicerectorComponent } from './inicio-vicerector.component';

describe('InicioVicerectorComponent', () => {
  let component: InicioVicerectorComponent;
  let fixture: ComponentFixture<InicioVicerectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InicioVicerectorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InicioVicerectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
