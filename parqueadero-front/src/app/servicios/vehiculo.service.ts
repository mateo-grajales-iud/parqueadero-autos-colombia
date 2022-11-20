import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

const baseUrl= 'http://localhost:8080/api/vehiculo/'

@Injectable({
  providedIn: 'root'
})
export class VehiculoService {

  constructor(private http: HttpClient ) { }

  crearVehiculo(data: any):Observable<any>{
    return this.http.post(baseUrl+'crearVehiculo',data, {
      headers: new HttpHeaders().set(
        'Content-Type','application/json'), 
        responseType: 'text' 
      });
  }

  obtenerTiposVehiculo(): Observable<any>{
    return this.http.get(baseUrl+'tiposVehiculo');
  }

  obtenerUsuarios(): Observable<any>{
    return this.http.get(baseUrl+'todosUsuarios');
  }
  
  obtenerVehiculos(): Observable<any>{
    return this.http.get(baseUrl+'todosVehiculos');
  }
}
