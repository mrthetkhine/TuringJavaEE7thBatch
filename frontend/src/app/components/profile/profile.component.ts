import {Component, computed, input} from '@angular/core';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  name = input.required<string>();
  profileImage = input('');

  nameInUpperCase = computed(()=>`${this.name().toUpperCase()}`);
}
