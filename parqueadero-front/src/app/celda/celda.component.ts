import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { VehiculoService } from '../servicios/vehiculo.service';
import { CeldaService } from '../servicios/celda.service';

@Component({
  selector: 'app-celda',
  templateUrl: './celda.component.html',
  styleUrls: ['./celda.component.css']
})
export class CeldaComponent implements OnInit {

celdaForm = this.formBuilder.group({
  id: [0, [Validators.required, Validators.min(1)]]
})

asociarForm = this.formBuilder.group({
  id: [0, [Validators.required, Validators.min(1)]],
  vehiculo : ["", Validators.required],
})

celdas : any = [];
vehiculos : any = [];

errorCrear = "";
exitoCrear = "";
errorAsociar = "";
exitoAsociar = "";

  constructor(private formBuilder: FormBuilder, private vehiculoService: VehiculoService, private celdaService: CeldaService) { 
    this.obtenerVehiculos();
    this.obtenerCeldas();
  }

  ngOnInit(): void {
  }

  onSubmit(){
    var data = this.celdaForm.value;
    this.celdaService.crearCelda(data).subscribe({
      next: (res) => {
        console.log(res);
        this.exitoCrear = "Celda creada!";
        this.errorCrear = "";
        this.obtenerCeldas();
      },
      error: (e) => {
        var mensaje = JSON.parse(e.error);
        this.exitoCrear = "";
        this.errorCrear = mensaje.mensaje;
      }
    })
  }

  obtenerVehiculos(){
    this.vehiculoService.obtenerVehiculos()
    .subscribe(res => {
      this.vehiculos = res     
    });
  }

  obtenerCeldas(){
    this.celdaService.obtenerCeldas()
    .subscribe(res => {
      this.celdas = res     
    });
  }

  asociar(){    
    var data = this.asociarForm.value;
    if (data.vehiculo == " "){
      data.vehiculo = "";
    }
    this.celdaService.asociarCelda(data).subscribe({
      next: (res) => {
        console.log(res);
        this.exitoAsociar = "Celda asociada!";
        this.errorAsociar = "";
        this.obtenerCeldas();
      },
      error: (e) => {
        var mensaje = JSON.parse(e.error);
        this.exitoAsociar = "";
        this.errorAsociar = mensaje.mensaje;
      }
    })
  }

}
