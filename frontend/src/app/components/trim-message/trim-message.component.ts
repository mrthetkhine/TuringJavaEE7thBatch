import {Component, input, numberAttribute} from '@angular/core';

function trimString(value: string | undefined): string {
  console.log('Trimstring ',value);
  return value?.trim() ?? '';
}
@Component({
  selector: 'app-trim-message',
  standalone: true,
  imports: [],
  templateUrl: './trim-message.component.html',
  styleUrl: './trim-message.component.css'
})
export class TrimMessageComponent {
  message = input('', {transform: trimString});
  value = input(0, {transform: numberAttribute});
}
