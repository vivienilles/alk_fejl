import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pizza } from 'src/domain/pizza';
import { PizzaService } from '../pizza.service';
import { PizzaStatus } from 'src/domain/pizza-status';

@Component({
  selector: 'app-pizza-new',
  templateUrl: './pizza-new.component.html',
  styleUrls: ['./pizza-new.component.css']
})
export class PizzaNewComponent implements OnInit {

  pizza: Pizza;

  constructor(
    private pizzaService: PizzaService,
    private router: Router
  ) { }

  ngOnInit() {
    this.pizza = {
      id: null,
      title: '',
      iningredient: '',
      status: 'NEW' as PizzaStatus,
      description: '',
      createdAt: null,
      modifiedAt: null,
      messages: null,
    };
  }
  async submitIssue(pizza: Pizza) {
    await this.pizzaService.createPizza(pizza);
    this.router.navigate(['/', 'pizzas']);
  }
}
