import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieNewFormDialogComponent } from './movie-new-form-dialog.component';

describe('MovieNewFormDialogComponent', () => {
  let component: MovieNewFormDialogComponent;
  let fixture: ComponentFixture<MovieNewFormDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovieNewFormDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MovieNewFormDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
