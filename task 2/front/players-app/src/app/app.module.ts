import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {RouterModule, Router} from '@angular/router'

import { AppComponent } from './app.component';
import {LoginComponent} from './loginComponent/login.component';
import {GanadorComponent} from './ganadorComponent/ganador.component';
import {EditorComponent} from './editorComponent/editor.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    GanadorComponent,
    EditorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      { 
        path: '', 
        component: LoginComponent
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'editor',
        component: EditorComponent
      },
      {
        path: 'predictor',
        component: GanadorComponent
      },
      {
        path: '**',
        component: LoginComponent
      }
  ], { useHash: false })],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
