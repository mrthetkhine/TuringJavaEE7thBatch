import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwoWayBindingDemoComponent } from './two-way-binding-demo.component';

describe('TwoWayBindingDemoComponent', () => {
  let component: TwoWayBindingDemoComponent;
  let fixture: ComponentFixture<TwoWayBindingDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TwoWayBindingDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TwoWayBindingDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
