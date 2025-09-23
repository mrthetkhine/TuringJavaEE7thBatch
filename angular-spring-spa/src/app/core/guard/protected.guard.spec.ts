import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { protectedGuard } from './protected.guard';

describe('protectedGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => protectedGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
