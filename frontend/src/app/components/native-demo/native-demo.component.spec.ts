import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NativeDemoComponent } from './native-demo.component';

describe('NativeDemoComponent', () => {
  let component: NativeDemoComponent;
  let fixture: ComponentFixture<NativeDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NativeDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NativeDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
