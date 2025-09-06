import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OuterComponent } from './outer.component';

describe('OuterComponent', () => {
  let component: OuterComponent;
  let fixture: ComponentFixture<OuterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OuterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OuterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
