import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActorListPageComponent } from './actor-list-page.component';

describe('ActorListPageComponent', () => {
  let component: ActorListPageComponent;
  let fixture: ComponentFixture<ActorListPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActorListPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActorListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
