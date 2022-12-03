import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PagosService } from '../servicios/pagos.service';

@Component({
  selector: 'app-pagos',
  templateUrl: './pagos.component.html',
  styleUrls: ['./pagos.component.css']
})
export class PagosComponent implements OnInit {

  pagos: any = [];

  generando: boolean = false;

  error = "";
  exito = "";

  pagarForm = this.formBuilder.group(
    {
      id: ['', Validators.required]
    })

  constructor(private formBuilder: FormBuilder, private pagoService: PagosService) {
    this.pagosPendientes();
  }

  ngOnInit(): void {
  }

  pagosPendientes() {
    this.pagoService.getTodas()
      .subscribe(res => {
        this.pagos = res;
      })
  }

  onSubmitFacturar() {
    if (!this.generando) {
      this.generando = true;
      this.pagoService.generar()
        .subscribe({
          next: (res) => {
            this.pagos = res;
            this.generando = false;
          },
          error: (e) => {
            this.pagosPendientes();
            this.generando = false;
          }
        });
    }
    return false;
  }

  pagar() {
    var data = { id : '' };
    data.id = this.pagarForm.value.id ?? '';
    this.pagoService.pagar(data)
    .subscribe({
      next: (res) => {
        this.exito = "Se ha generado el pago con exito";
        this.error = ""; 
        this.pagosPendientes();
      },
      error: (e) => {
        this.exito = "";
        this.error = "Ha ocurrido un error";
      }
    })
  }

}
