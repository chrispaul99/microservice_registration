import { TestBed } from '@angular/core/testing';

import { InstructivoService } from './instructivo.service';

describe('InstructivoService', () => {
  let service: InstructivoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InstructivoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
