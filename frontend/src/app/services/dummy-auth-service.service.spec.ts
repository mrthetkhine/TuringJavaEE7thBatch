import { TestBed } from '@angular/core/testing';

import { DummyAuthServiceService } from './dummy-auth-service.service';

describe('DummyAuthServiceService', () => {
  let service: DummyAuthServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DummyAuthServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
