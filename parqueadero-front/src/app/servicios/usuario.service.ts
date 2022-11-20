import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

const baseUrl= 'http://localhost:8080/api/usuario/'

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient ) { }

  crearUsuario(data: any):Observable<any>{
    return this.http.post(baseUrl+'crearUsuario',data, {
      headers: new HttpHeaders().set(
        'Content-Type','application/json'), 
        responseType: 'text' 
      });
  }

  obtenerTiposDocumento(): Observable<any>{
    return this.http.get(baseUrl+'tiposDocumento');
  }

  obtenerUsuarios(): Observable<any>{
    return this.http.get(baseUrl+'todosUsuarios');
  }

}
