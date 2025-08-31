import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrimMessageComponent } from './trim-message.component';

describe('TrimMessageComponent', () => {
  let component: TrimMessageComponent;
  let fixture: ComponentFixture<TrimMessageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TrimMessageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TrimMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
