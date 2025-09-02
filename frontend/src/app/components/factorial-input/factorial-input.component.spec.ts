import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FactorialInputComponent } from './factorial-input.component';

describe('FactorialInputComponent', () => {
  let component: FactorialInputComponent;
  let fixture: ComponentFixture<FactorialInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FactorialInputComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FactorialInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
