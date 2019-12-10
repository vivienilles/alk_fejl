import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Pizza } from 'src/domain/pizza';
import { PizzaService } from '../pizza.service';

@Component({
  selector: 'app-pizza-edit',
  templateUrl: './pizza-edit.component.html',
  styleUrls: ['./pizza-edit.component.css']
})
export class PizzaEditComponent implements OnInit {

  pizza: Pizza;

  constructor(
    private pizzaService: PizzaService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  async ngOnInit() {
    // tslint:disable-next-line: radix
    const pizzaId = parseInt(
      this.route.snapshot.params.id);
    this.pizza = await this.pizzaService.getPizza(pizzaId);
  }

  async submitPizza(pizza: Pizza) {
    pizza.id = this.pizza.id;
    await this.pizzaService.modifyPizza(pizza);
    this.router.navigate(['/', 'pizzas']);
  }

}
