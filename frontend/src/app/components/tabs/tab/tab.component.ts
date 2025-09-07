import {Component, contentChildren, ContentChildren, input, QueryList, TemplateRef} from '@angular/core';
import {TabPageComponent} from "../tab-page/tab-page.component";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-tab',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './tab.component.html',
  styleUrl: './tab.component.css'
})
export class TabComponent {
  headers = input<string[]>([]);
  pages= contentChildren(TabPageComponent);

  ngAfterContentInit() {
    // contentChildren is set
    console.log('Page ',this.pages());
    this.showPage(0);
  }
  showPage(pageIndex:number){
    console.log('page index ',pageIndex);
    let pages =this.pages();
    for (let i = 0; i <pages.length; i++) {
      pages[i].isShow = false;
    }
    pages[pageIndex].showPage();
  }
}
