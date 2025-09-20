import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActorUiComponent } from './actor-ui.component';

describe('ActorUiComponent', () => {
  let component: ActorUiComponent;
  let fixture: ComponentFixture<ActorUiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActorUiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActorUiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
