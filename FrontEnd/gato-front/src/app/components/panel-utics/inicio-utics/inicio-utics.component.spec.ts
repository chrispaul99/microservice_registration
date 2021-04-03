import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioUticsComponent } from './inicio-utics.component';

describe('InicioUticsComponent', () => {
  let component: InicioUticsComponent;
  let fixture: ComponentFixture<InicioUticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InicioUticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InicioUticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
