import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelDirectorCarreraComponent } from './panel-director-carrera.component';

describe('PanelDirectorCarreraComponent', () => {
  let component: PanelDirectorCarreraComponent;
  let fixture: ComponentFixture<PanelDirectorCarreraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PanelDirectorCarreraComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PanelDirectorCarreraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
