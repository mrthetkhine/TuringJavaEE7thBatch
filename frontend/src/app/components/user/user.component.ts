import {Component, computed, inject} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {toSignal} from "@angular/core/rxjs-interop";

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
  private route = inject(ActivatedRoute);
  private data = toSignal(this.route.data);
  user = computed(() =>( this.data() as any).user);
}
