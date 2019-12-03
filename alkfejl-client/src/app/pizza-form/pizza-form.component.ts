import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Pizza } from 'src/domain/pizza';
import { FormGroup } from '@angular/forms';
import { PizzaStatus } from 'src/domain/pizza-status';
import { PizzaService } from '../pizza.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pizza-form',
  templateUrl: './pizza-form.component.html',
  styleUrls: ['./pizza-form.component.css']
})
export class PizzaFormComponent implements OnInit {

  @Input() mode: 'create' | 'edit';
  @Input() pizza: Pizza;
  @Output() pizzaSubmit: EventEmitter<Pizza> = new EventEmitter();

  statuses = [{
    label: 'New',
    value: 'NEW',
  }, {
    label: 'In progress',
    value: 'DOING',
  }, {
    label: 'Done',
    value: 'DONE',
  }];

  constructor() { }

  ngOnInit() {}

  async submitPizza(form: FormGroup) {
    if (!form.valid) {
      return;
    }
    this.pizzaSubmit.emit(form.getRawValue() as Pizza);
  }

}
