import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeavyComponentComponent } from './heavy-component.component';

describe('HeavyComponentComponent', () => {
  let component: HeavyComponentComponent;
  let fixture: ComponentFixture<HeavyComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HeavyComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HeavyComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
