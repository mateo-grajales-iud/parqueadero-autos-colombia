import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup} from '@angular/forms';

import { RegistroService } from '../servicios/registro.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  registroForm= this.formBuilder.group(
    {
      placa: '',
      fecha: '',
      hora: ''
     })

  constructor(private registroService: RegistroService, private formBuilder: FormBuilder) { }

  onSubmit(boton:string): void {
    var data= {
      placa: '', entrada: '', salida: ''
    };

    data.placa = this.registroForm.value.placa ?? '';
    data.placa = data.placa.toUpperCase();

    if (boton=='ENTRADA'){
      data.entrada = this.registroForm.value.fecha ?? '';
      data.entrada += ' ' + (this.registroForm.value.hora ?? '') + ':00';
      this.registroService.registrarEntrada(data)
        .subscribe({
          next: (res) => {
            console.log(res);
          },
          error: (e) => {
            console.error(e);
          }
        })
    }
    else {
      data.salida= this.registroForm.value.fecha ?? '';
      data.salida += ' ' + (this.registroForm.value.hora ?? '') + ':00';
    }
    console.warn(data);
  }

  ngOnInit(): void {
  }

}

