import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrossTwoWayBindingDemoComponent } from './cross-two-way-binding-demo.component';

describe('CrossTwoWayBindingDemoComponent', () => {
  let component: CrossTwoWayBindingDemoComponent;
  let fixture: ComponentFixture<CrossTwoWayBindingDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrossTwoWayBindingDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrossTwoWayBindingDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
