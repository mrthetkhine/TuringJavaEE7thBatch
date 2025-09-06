import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControlFlowDemoComponent } from './control-flow-demo.component';

describe('ControlFlowDemoComponent', () => {
  let component: ControlFlowDemoComponent;
  let fixture: ComponentFixture<ControlFlowDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ControlFlowDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ControlFlowDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
