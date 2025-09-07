import { Component } from '@angular/core';

@Component({
  selector: 'app-tab-page',
  standalone: true,
  imports: [],
  templateUrl: './tab-page.component.html',
  styleUrl: './tab-page.component.css'
})
export class TabPageComponent {

  isShow = false;
  showPage()
  {
    this.isShow = true;
  }
}
