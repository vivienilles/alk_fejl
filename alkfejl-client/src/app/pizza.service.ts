import { Injectable } from '@angular/core';
import { PizzaStatus } from 'src/domain/pizza-status';
import { Pizza } from 'src/domain/pizza';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PizzaService {

  pizzas: Pizza[] = [];

  filteredPizzas: Pizza[] = this.pizzas;

  constructor(
    private http: HttpClient
  ) { }

  async getPizzas() {
    const pizzas = await (this.http.get('pizzas')
      .toPromise() as Promise<any[]>);
    this.filteredPizzas = this.pizzas = pizzas.map(this.createPizzaModel);
  }

  async getPizza(pizzaId: number): Promise<Pizza> {
    const pizza = await (this.http.get(`pizzas/${pizzaId}`)
      .toPromise() as Promise<any>);
    return this.createPizzaModel(pizza);
  }

  async createPizza(pizza: Pizza): Promise<any> {
    await this.http.post('pizzas', pizza).toPromise();
  }
  
  async modifyPizza(pizza: Pizza): Promise<any> {
    await this.http.patch(`pizzas/${pizza.id}`, pizza).toPromise();
  }

  filterChange(filterValue: string) {
    if (typeof filterValue === 'string') {
      if (filterValue === '') {
        this.filteredPizzas = this.pizzas;
      } else {
        // Lehet ciklussal is :)
        this.filteredPizzas = this.pizzas.filter(issue => {
          return pizza.status === filterValue;
        });
      }
    }
  }

  private createPizzaModel(pizza: any): Pizza {
    return {
      ...pizza,
      createdAt: new Date(pizza.createdAt),
    } as Pizza;
  }
}
