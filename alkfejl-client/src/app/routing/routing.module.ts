import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PizzaListComponent } from '../pizza-list/pizza-list.component';
import { PizzaFormComponent } from '../pizza-form/pizza-form.component';
import { LandingComponent } from '../landing/landing.component';
import { PizzaDetailComponent } from '../pizza-detail/pizza-detail.component';
import { PizzaNewComponent } from '../pizza-new/pizza-new.component';
import { PizzaEditComponent } from '../pizza-edit/pizza-edit.component';
import { LoginComponent } from '../login/login.component';
import { UserRole } from 'src/domain/user-role';
import { RoleGuard } from '../role.guard';

const routes: Routes = [
  {
    path: '',
    component: LandingComponent,
    pathMatch: 'full'
  },
  {
    path: 'pizza',
    component: PizzaListComponent,
    data: {
      roles: [UserRole.Admin, UserRole.User],
    },
    canActivate: [RoleGuard],
  },
  {
    path: 'pizza/new',
    component: PizzaNewComponent,
    data: {
      roles: [UserRole.User],
    },
    canActivate: [RoleGuard],
  },
  {
    path: 'pizza/:id',
    component: PizzaDetailComponent,
    data: {
      roles: [UserRole.Admin, UserRole.User],
    },
    canActivate: [RoleGuard],
  },
  {
    path: 'pizza/:id/edit',
    component: PizzaEditComponent,
    data: {
      roles: [UserRole.Admin],
    },
    canActivate: [RoleGuard],
  },
  {
    path: 'login',
    component: LoginComponent,
    data: {
      roles: [UserRole.Guest],
    },
    canActivate: [RoleGuard],
  },
  {
    path: '**',
    redirectTo: '/',
  },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }
