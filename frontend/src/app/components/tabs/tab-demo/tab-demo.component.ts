import {Component, inject} from '@angular/core';
import {TabComponent} from "../tab/tab.component";
import {TabPageComponent} from "../tab-page/tab-page.component";
import {LoggerService} from "../../../services/logger.service";

@Component({
  selector: 'app-tab-demo',
  standalone: true,
  imports: [
    TabComponent,
    TabPageComponent,
  ],
  templateUrl: './tab-demo.component.html',
  styleUrl: './tab-demo.component.css'
})
export class TabDemoComponent {
  headers = ["Page1 ","Page 2","Page 3"];
  loggerService =inject(LoggerService);

  constructor() {
    this.loggerService.log("Tab created");
  }
}
