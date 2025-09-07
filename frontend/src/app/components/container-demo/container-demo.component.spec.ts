import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerDemoComponent } from './container-demo.component';

describe('ContainerDemoComponent', () => {
  let component: ContainerDemoComponent;
  let fixture: ComponentFixture<ContainerDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContainerDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ContainerDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
