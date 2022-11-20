import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup} from '@angular/forms';

import { VehiculoService } from '../servicios/vehiculo.service';

@Component({
  selector: 'app-vehiculo',
  templateUrl: './vehiculo.component.html',
  styleUrls: ['./vehiculo.component.css']
})
export class VehiculoComponent implements OnInit {

  crearVehiculoForm = this.formBuilder.group({
    marca : "",
    modelo : "",
    color : "",
    placa : "",
    tipo : ""
  })

  constructor(private formBuilder: FormBuilder, private vehiculoService: VehiculoService) { }

  ngOnInit(): void {
  }

}
