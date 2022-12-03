import { Component, OnInit } from '@angular/core';
import { RegistroService } from '../servicios/registro.service';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Timestamp, timestamp } from 'rxjs';

@Component({
  selector: 'app-historial',
  templateUrl: './historial.component.html',
  styleUrls: ['./historial.component.css']
})
export class HistorialComponent implements OnInit {

  registros: any = [];

  buscarForm = this.formBuilder.group({
    fecha: ['', Validators.required]
  })

  constructor(private registroService: RegistroService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

  onSubmit():void{
    console.log(this.registros);
    this.registroService.buscarHistorial(this.buscarForm.value.fecha ?? '')
      .subscribe(res => {
        this.registros = res;
        console.log(this.registros);
      })
  }

}
