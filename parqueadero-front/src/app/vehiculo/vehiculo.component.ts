import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { UsuarioService } from '../servicios/usuario.service';
import { VehiculoService } from '../servicios/vehiculo.service';

@Component({
  selector: 'app-vehiculo',
  templateUrl: './vehiculo.component.html',
  styleUrls: ['./vehiculo.component.css']
})
export class VehiculoComponent implements OnInit {

  crearVehiculoForm = this.formBuilder.group({
    marca : ["", Validators.required],
    modelo : ["", Validators.required],
    color : ["", Validators.required],
    placa : ["", Validators.required],
    tipo : ["", Validators.required],
    dueno : ["", Validators.required]
  })

  errorCrear : String = "";
  exitoCrear : String = "";

  factura = "";

  tiposVehiculo : any = [];
  usuarios : any = [];
  vehiculos : any = [];

  constructor(private formBuilder: FormBuilder, private vehiculoService: VehiculoService, private usuarioService: UsuarioService) { 
    this.getTiposVehiculo();
    this.getUsuarios();
    this.getVehiculos();
  }

  ngOnInit(): void {
  }

  onSubmit(){
    var data = this.crearVehiculoForm.value;
    this.vehiculoService.crearVehiculo(data).subscribe({
      next: (res) => {
        console.log(res);
        this.exitoCrear = "Vehiculo creado!";
        this.errorCrear = "";
        this.getVehiculos();
      },
      error: (e) => {
        var mensaje = JSON.parse(e.error);
        this.exitoCrear = "";
        this.errorCrear = mensaje.mensaje;
      }
    })
  }

  getTiposVehiculo(){
    this.vehiculoService.obtenerTiposVehiculo()
      .subscribe(res => {
        this.tiposVehiculo = res     
      });
  }

  getUsuarios(){
    this.usuarioService.obtenerUsuarios()
      .subscribe(res => {
        this.usuarios = res;
      })
  }

  getVehiculos(){
    this.vehiculoService.obtenerVehiculos()
    .subscribe(res => {
      this.vehiculos = res     
    });
  }

}
