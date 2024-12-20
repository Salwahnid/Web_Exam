import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {LayoutComponent} from "./layout.component";
import {CustomerHistoryComponent} from "./components/customer-history/customer-history.component";

const routes: Routes = [
  {
    path: '',  // Route pour le Dashboard
    redirectTo: 'doctor-owner/dashboard',
    pathMatch: 'full',
  },
  {
    path: 'doctor-owner',  // Route pour le Dashboard
    component: LayoutComponent,  // Assuming LayoutComponent is the parent container
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'customer_history',
        component: CustomerHistoryComponent  // Replace with your actual component
      }
      // Ajoutez d'autres routes pour cette fonctionnalité ici
    ]
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DoctorOwnerRoutingModule { }
