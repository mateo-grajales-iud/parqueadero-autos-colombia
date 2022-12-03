import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';

import { RegistroService } from '../servicios/registro.service';
import { VehiculoService } from '../servicios/vehiculo.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  error = "";
  exito = "";

  vehiculos : any = [];

  registroForm= this.formBuilder.group(
    {
      placa: ['', Validators.required],
      fecha: ['', Validators.required],
      hora: ['', Validators.required]
     })

  constructor(private registroService: RegistroService, private vehiculoService : VehiculoService, private formBuilder: FormBuilder) { 
    this.getVehiculos();
  }

  getVehiculos(){
    this.vehiculoService.obtenerVehiculos()
      .subscribe(res => {
        this.vehiculos = res;
      });
  }

  onSubmit(boton:string): void {
    console.log("click on entrada");
    var data= {
      placa: '', fecha: '', tipo: ''
    };

    data.placa = this.registroForm.value.placa ?? '';
    data.placa = data.placa.toUpperCase();
    data.fecha= this.registroForm.value.fecha ?? '';
    data.fecha += ' ' + (this.registroForm.value.hora ?? '') + ':00';

    if (boton=='ENTRADA'){
      data.tipo = '1';
      this.registroService.registrarEntrada(data)
        .subscribe({
          next: (res) => {
            console.log(res);
            this.registroForm.reset();
            this.exito = "Se ha creado el registro con exito";
            this.error = "";            
          },
          error: (e) => {
            console.error(e);
            this.exito = "";
            this.error = "Ha ocurrido un error";
          }
        })
    }
    else {
      data.tipo = '2';
      this.registroService.registrarSalida(data)
        .subscribe({
          next: (res) => {
            console.log(res);
            this.registroForm.reset();
            this.exito = "Se ha creado el registro con exito";
            this.error = ""; 
          },
          error: (e) => {
            console.error(e);
            this.exito = "";
            this.error = "Ha ocurrido un error";
          }
        })
    }
    console.warn(data);
  }

  ngOnInit(): void {
  }

}

