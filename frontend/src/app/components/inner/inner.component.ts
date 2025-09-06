import {Component, inject, ViewContainerRef} from '@angular/core';
import {LeafContentComponent} from "../leaf-content/leaf-content.component";
import {FormsModule} from "@angular/forms";
import {UserComponent} from "../user/user.component";

@Component({
  selector: 'app-inner',
  standalone: true,
  imports: [
    FormsModule,
  ],
  templateUrl: './inner.component.html',
  styleUrl: './inner.component.css'
})
export class InnerComponent {
  private viewContainer = inject(ViewContainerRef);

  isLeaf = false;

  constructor() {
    console.log('inner component view container ',this.viewContainer);
  }
  loadContent() {
    console.log('is leaf ',this.isLeaf);
    if (this.isLeaf) {
      this.viewContainer.createComponent(LeafContentComponent);
    }
    else
    {
      this.viewContainer.createComponent(UserComponent);
    }
  }
}
