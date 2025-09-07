import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerPage2Component } from './container-page2.component';

describe('ContainerPage2Component', () => {
  let component: ContainerPage2Component;
  let fixture: ComponentFixture<ContainerPage2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContainerPage2Component]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ContainerPage2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
