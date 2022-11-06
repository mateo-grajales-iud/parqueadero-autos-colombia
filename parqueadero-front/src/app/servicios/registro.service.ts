import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';


const baseUrl= 'http://localhost:8080/api/registro/';


@Injectable({
  providedIn: 'root'
})
export class RegistroService {

  constructor(private http: HttpClient ) {
    
   } 
  
  registrarEntrada(data: any):Observable<any>{
    return this.http.post(baseUrl+'entrada',data, {
      headers: new HttpHeaders().set(
        'Content-Type','application/json'), 
        responseType: 'text' 
      });
  }

  registrarSalida(data: any):Observable<any>{
    return this.http.post(baseUrl+'salida',data, {
      headers: new HttpHeaders().set(
        'Content-Type','application/json'), 
        responseType: 'text' 
      });
  }

  buscarHistorial(data: any): Observable<any>{
    return this.http.get(baseUrl+'historial/'+data);
  }
}
