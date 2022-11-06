import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistroComponent } from './registro/registro.component';
import { HistorialComponent } from './historial/historial.component';

const routes: Routes = [
  {path: 'registro', component: RegistroComponent},
  {path: 'historial', component: HistorialComponent},

  {path: '**', redirectTo: '/registro', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }