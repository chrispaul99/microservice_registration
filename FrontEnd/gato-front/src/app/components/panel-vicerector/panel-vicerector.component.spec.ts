import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelVicerectorComponent } from './panel-vicerector.component';

describe('PanelVicerectorComponent', () => {
  let component: PanelVicerectorComponent;
  let fixture: ComponentFixture<PanelVicerectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PanelVicerectorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PanelVicerectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
