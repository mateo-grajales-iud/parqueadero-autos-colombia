import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';


const baseUrl = 'http://localhost:8080/api/pagos/';

@Injectable({
  providedIn: 'root'
})
export class PagosService {

  constructor(private http: HttpClient) {

  }

  getTodas(): Observable<any> {
    return this.http.get(baseUrl + 'todosPagos');
  }

  generar(): Observable<any> {
    return this.http.get(baseUrl + 'generar');
  }

  pagar(data: any): Observable<any> {
    return this.http.post(baseUrl + 'pagar', data, {
      headers: new HttpHeaders().set(
        'Content-Type', 'application/json'),
      responseType: 'text'
    });
  }
}
