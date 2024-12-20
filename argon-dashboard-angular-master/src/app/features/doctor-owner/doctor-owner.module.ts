import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {NavbarComponent} from "./components/navbar/navbar.component";
import {FooterComponent} from "./components/footer/footer.component";
import {CommonModule} from "@angular/common";
import {SidebarComponent} from "./components/sidebar/sidebar.component";
import {LayoutComponent} from "./layout.component";
import {DoctorOwnerRoutingModule} from "./doctor-owner-routing.module";
import { NgbCollapseModule } from '@ng-bootstrap/ng-bootstrap';
import { CustomerHistoryComponent } from './components/customer-history/customer-history.component';



@NgModule({
  declarations: [ //les composants on les declare ici
    DashboardComponent,
    SidebarComponent,
    NavbarComponent,
    FooterComponent,
    LayoutComponent,
    CustomerHistoryComponent

  ],
  imports: [ //Contient une liste de modules externes dont ce module dépend.
    CommonModule,
    DoctorOwnerRoutingModule,
    NgbCollapseModule

  ],

})
export class DoctorownerModule { }
