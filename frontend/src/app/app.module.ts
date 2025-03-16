import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DataService } from './data.service';

@NgModule({
  // import HttpClientModule after BrowserModule.
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  declarations: [
    AppComponent
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
