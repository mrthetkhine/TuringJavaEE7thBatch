import {Directive, ElementRef, HostListener, inject} from '@angular/core';
import {LoggerService} from "./services/logger.service";

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {
  private el = inject(ElementRef);

  loggerService = inject(LoggerService);

  constructor() {
    this.el.nativeElement.style.backgroundColor = 'yellow';
  }

  @HostListener('mouseenter') onMouseEnter() {
    this.highlight('yellow');
    this.loggerService.log('mouse enter');
  }
  @HostListener('mouseleave') onMouseLeave() {
    this.highlight('');
  }
  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }
}
