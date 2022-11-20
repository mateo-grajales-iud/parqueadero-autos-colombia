import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistroComponent } from './registro/registro.component';
import { HistorialComponent } from './historial/historial.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { VehiculoComponent } from './vehiculo/vehiculo.component';
import { CeldaComponent } from './celda/celda.component';

const routes: Routes = [
  {path: 'registro', component: RegistroComponent},
  {path: 'historial', component: HistorialComponent},
  {path: 'usuario', component: UsuarioComponent},
  {path: 'vehiculo', component: VehiculoComponent},
  {path: 'celda', component: CeldaComponent},

  {path: '**', redirectTo: '/registro', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
