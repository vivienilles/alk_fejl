import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// tslint:disable-next-line: max-line-length
import { MatToolbarModule, MatIconModule, MatButtonModule, MatOptionModule, MatSelectModule, MatButtonToggleModule } from '@angular/material';
import { PizzaListComponent } from './pizza-list/pizza-list.component';
import { RoutingModule } from './routing/routing.module';
import { LandingComponent } from './landing/landing.component';
import { PizzaFormComponent } from './pizza-form/pizza-form.component';
import { MatInputModule } from '@angular/material/input';
import { StatusFilterComponent } from './status-filter/status-filter.component';
import { PizzaDetailComponent } from './pizza-detail/pizza-detail.component';
import { PizzaNewComponent } from './pizza-new/pizza-new.component';
import { PizzaEditComponent } from './pizza-edit/pizza-edit.component';
import { LoginComponent } from './login/login.component';
import { RoleDirective } from './role.directive';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PizzaListComponent,
    LandingComponent,
    PizzaFormComponent,
    StatusFilterComponent,
    PizzaDetailComponent,
    PizzaNewComponent,
    PizzaEditComponent,
    LoginComponent,
    RoleDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    RoutingModule,
    MatInputModule,
    FormsModule,
    MatOptionModule,
    MatSelectModule,
    MatButtonToggleModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
