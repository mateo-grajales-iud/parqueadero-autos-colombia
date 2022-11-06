import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistroComponent } from './registro/registro.component';
import { BarraSuperiorComponent } from './barra-superior/barra-superior.component';
import { BarraInferiorComponent } from './barra-inferior/barra-inferior.component';
import { HistorialComponent } from './historial/historial.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistroComponent,
    BarraSuperiorComponent,
    BarraInferiorComponent,
    HistorialComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
