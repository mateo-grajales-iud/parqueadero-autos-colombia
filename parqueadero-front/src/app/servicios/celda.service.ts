import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

const baseUrl= 'http://localhost:8080/api/celda/'

@Injectable({
  providedIn: 'root'
})
export class CeldaService {

  constructor(private http: HttpClient) { }

  crearCelda(data: any):Observable<any>{
    return this.http.post(baseUrl+'crearCelda',data, {
      headers: new HttpHeaders().set(
        'Content-Type','application/json'), 
        responseType: 'text' 
      });
  }

  asociarCelda(data: any):Observable<any>{
    return this.http.post(baseUrl+'asociarCelda',data, {
      headers: new HttpHeaders().set(
        'Content-Type','application/json'), 
        responseType: 'text' 
      });
  }

  obtenerCeldas(): Observable<any>{
    return this.http.get(baseUrl+'todasCeldas');
  }
}
