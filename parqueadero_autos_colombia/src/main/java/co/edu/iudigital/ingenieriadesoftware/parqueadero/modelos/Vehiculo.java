package co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Vehiculo {
	
	@Id
	@Column(length = 6)
	private String placa;
	
	@Column(length = 20, nullable = false)
	private String marca;
	
	@Column(length = 10, nullable = false)
	private String modelo;
	
	@Column(length = 20, nullable = false)
	private String color;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo", nullable = false)
	private TipoVehiculo tipo;
	
	public Vehiculo() {}

	public Vehiculo(String placa, String marca, String modelo, String color, TipoVehiculo tipo) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public TipoVehiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}

}
