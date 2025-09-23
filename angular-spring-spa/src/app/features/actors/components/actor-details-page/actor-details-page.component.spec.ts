import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActorDetailsPageComponent } from './actor-details-page.component';

describe('ActorDetailsPageComponent', () => {
  let component: ActorDetailsPageComponent;
  let fixture: ComponentFixture<ActorDetailsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActorDetailsPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActorDetailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
