import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarInstructivosComponent } from './listar-instructivos.component';

describe('ListarInstructivosComponent', () => {
  let component: ListarInstructivosComponent;
  let fixture: ComponentFixture<ListarInstructivosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarInstructivosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarInstructivosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
