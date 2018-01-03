import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {UserService} from './shared-service/user.service';
import {HttpModule} from '@angular/http';

import { AppComponent } from './app.component';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';

const appRoutes: Routes = [
  {
    path: '',
    component: ListuserComponent
  },
  {
    path: 'op',
    component: UserFormComponent
  }

];

@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpModule,
    BrowserModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
