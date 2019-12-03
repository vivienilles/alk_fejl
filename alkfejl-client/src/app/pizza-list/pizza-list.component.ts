import { Component, OnInit } from '@angular/core';
import { Pizza } from 'src/domain/pizza';
import { PizzaStatus } from 'src/domain/pizza-status';
import { PizzaService } from '../pizza.service';

@Component({
  selector: 'app-pizza-list',
  templateUrl: './pizza-list.component.html',
  styleUrls: ['./pizza-list.component.css']
})
export class PizzaListComponent implements OnInit {

  constructor(
    public pizzaService: PizzaService
  ) { }

  ngOnInit() {
    this.pizzaService.getPizzas();
  }

}
