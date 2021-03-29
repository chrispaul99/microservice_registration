import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioDirectorComponent } from './inicio-director.component';

describe('InicioDirectorComponent', () => {
  let component: InicioDirectorComponent;
  let fixture: ComponentFixture<InicioDirectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InicioDirectorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InicioDirectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
