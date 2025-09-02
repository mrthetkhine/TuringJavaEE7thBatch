import {Component, input} from '@angular/core';

@Component({
  selector: 'app-factorial',
  standalone: true,
  imports: [

  ],
  templateUrl: './factorial.component.html',
  styleUrl: './factorial.component.css'
})
export class FactorialComponent {
  inputNo = input<number>(0);

  factResult = 0;

  ngAfterContentInit()
  {
    console.log('ngAfterContentInit');
  }
  ngOnChanges() {
    console.log('Parent input change ');
    this.factorial();
  }
  ngDoCheck()
  {
    console.log('FactorialComponent ngDoCheck');
  }
  ngAfterContentChecked()
  {
    console.log('FactorialComponent ngAfterContentChecked');
  }
  afterEveryRender()
  {
    console.log('FactorialComponent afterEveryRender');
  }
  factorial()
  {
    let result = 1;
    for(let i=1;i<=this.inputNo();i++)
    {
      result *=i;
    }
    this.factResult = result;
  }
}
