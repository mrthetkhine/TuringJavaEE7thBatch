import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieEditPageComponent } from './movie-edit-page.component';

describe('MovieEditPageComponent', () => {
  let component: MovieEditPageComponent;
  let fixture: ComponentFixture<MovieEditPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovieEditPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MovieEditPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
