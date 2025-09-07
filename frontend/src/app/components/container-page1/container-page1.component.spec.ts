import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerPage1Component } from './container-page1.component';

describe('ContainerPage1Component', () => {
  let component: ContainerPage1Component;
  let fixture: ComponentFixture<ContainerPage1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContainerPage1Component]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ContainerPage1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
