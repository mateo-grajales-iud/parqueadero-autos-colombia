import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';

import { UsuarioService } from '../servicios/usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  formCrearUsuario = this.formBuilder.group(
    {
      nombre: ['', Validators.required],
      apellidos: ['', Validators.required],
      tipoIdentificacion: ['', Validators.required],
      numIdentificacion: ['', Validators.required], 
      correo: ['', Validators.required],
      telefono: ['', Validators.required]
    }
  )

  tiposDoc : any = [];
  usuarios : any = [];

  error : String = "";
  exito : String = "";
  

  constructor(private formBuilder: FormBuilder, private usuarioService: UsuarioService) { 
    this.getTiposDocumento();
    this.getUsuarios();
  }

  ngOnInit(): void {
  }

  getTiposDocumento() {    
    this.usuarioService.obtenerTiposDocumento()
      .subscribe(res => {
        this.tiposDoc = res     
      });
  }

  getUsuarios() {
    this.usuarioService.obtenerUsuarios()
      .subscribe(res => {
        this.usuarios = res;
      })
  }

  onSubmit(){
    var data = {
      id: this.formCrearUsuario.value.numIdentificacion,
      nombres : this.formCrearUsuario.value.nombre,
      apellidos: this.formCrearUsuario.value.apellidos,
      tipoDocumento: this.formCrearUsuario.value.tipoIdentificacion,
      numeroDocumento: this.formCrearUsuario.value.numIdentificacion, 
      correoElectronico: this.formCrearUsuario.value.correo,
      telefono: this.formCrearUsuario.value.telefono
    }
    this.usuarioService.crearUsuario(data).subscribe({
      next: (res) => {
        console.log(res);
        this.exito = "Usuario creado!";
        this.error = "";
        this.getUsuarios();
        this.formCrearUsuario.reset();
      },
      error: (e) => {
        var mensaje = JSON.parse(e.error);
        this.exito = "";
        this.error = mensaje.mensaje;
      }
    })
  }

}
