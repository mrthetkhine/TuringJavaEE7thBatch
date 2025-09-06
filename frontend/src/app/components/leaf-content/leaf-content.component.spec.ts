import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeafContentComponent } from './leaf-content.component';

describe('LeafContentComponent', () => {
  let component: LeafContentComponent;
  let fixture: ComponentFixture<LeafContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LeafContentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LeafContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
