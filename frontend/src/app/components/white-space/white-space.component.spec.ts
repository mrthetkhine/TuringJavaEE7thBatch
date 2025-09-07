import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WhiteSpaceComponent } from './white-space.component';

describe('WhiteSpaceComponent', () => {
  let component: WhiteSpaceComponent;
  let fixture: ComponentFixture<WhiteSpaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WhiteSpaceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WhiteSpaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
