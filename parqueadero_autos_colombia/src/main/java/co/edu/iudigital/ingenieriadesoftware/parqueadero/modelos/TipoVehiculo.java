package co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoVehiculo {
	
	@Id
	@Column(length = 2, nullable = false)
	private String tipo;
	
	@Column(length = 20, nullable = false)
	private String descripcion;
	
	public TipoVehiculo() {}

	public TipoVehiculo(String tipo, String descripcion) {
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
