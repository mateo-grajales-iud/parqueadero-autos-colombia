import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl= 'http://localhost:8080/api/registro/';


@Injectable({
  providedIn: 'root'
})
export class RegistroService {

  constructor(private http: HttpClient ) {
    
   } 
  
  registrarEntrada(data: any):Observable<any>{
    var headers = new Headers();
    headers.append ('Content-Type','application/json');
    return this.http.post(baseUrl+'entrada',data, {
      headers:headers
      
    });
  }

  registrarSalida(data: any):Observable<any>{
    return this.http.post(baseUrl+'salida',data);
  }

  buscarHistorial(data: any): Observable<any>{
    return this.http.get(baseUrl+'historial/'+data);
  }
}
