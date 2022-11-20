package co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoDocumento {
	
	@Id
	@Column(length = 2)
	private String tipo;
	
	@Column(nullable = false, length = 50)
	private String descripcion;
	
	public TipoDocumento() {}

	public TipoDocumento(String tipo, String descripcion) {
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
