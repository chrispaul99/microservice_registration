import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RevisarInstructivoComponent } from './revisar-instructivo.component';

describe('RevisarInstructivoComponent', () => {
  let component: RevisarInstructivoComponent;
  let fixture: ComponentFixture<RevisarInstructivoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RevisarInstructivoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RevisarInstructivoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
