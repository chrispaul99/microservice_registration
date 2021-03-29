import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelUticsComponent } from './panel-utics.component';

describe('PanelUticsComponent', () => {
  let component: PanelUticsComponent;
  let fixture: ComponentFixture<PanelUticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PanelUticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PanelUticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
