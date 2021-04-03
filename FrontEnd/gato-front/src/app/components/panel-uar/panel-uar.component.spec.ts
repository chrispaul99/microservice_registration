import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelUarComponent } from './panel-uar.component';

describe('PanelUarComponent', () => {
  let component: PanelUarComponent;
  let fixture: ComponentFixture<PanelUarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PanelUarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PanelUarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
