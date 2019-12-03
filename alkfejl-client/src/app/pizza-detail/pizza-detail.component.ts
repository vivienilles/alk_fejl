import { Component, OnInit } from '@angular/core';

import { Pizza } from 'src/domain/pizza';
import { ActivatedRoute, Router } from '@angular/router';
import { PizzaService } from '../pizza.service';
import { UserRole } from 'src/domain/user-role';

@Component({
  selector: 'app-pizza-detail',
  templateUrl: './pizza-detail.component.html',
  styleUrls: ['./pizza-detail.component.css']
})
export class PizzaDetailComponent implements OnInit {

  UserRole = UserRole;
  pizza: Pizza;

  constructor(
    private route: ActivatedRoute,
    private pizzaService: PizzaService,
    private router: Router
  ) { }

  async ngOnInit() {
    // tslint:disable-next-line: radix
    const pizzaId = parseInt(
      this.route.snapshot.params.id);
    this.pizza = await this.pizzaService.getPizza(pizzaId);
  }

  editPizza() {
    this.router.navigate([
      'pizzas', this.pizza.id, 'edit']);
  }
}
