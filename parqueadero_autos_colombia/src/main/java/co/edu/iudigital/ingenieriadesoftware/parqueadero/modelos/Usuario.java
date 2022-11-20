package co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	
	@Id
	@Column(length = 10)
	private String id;
	
	@Column(length = 100, nullable = false)
	private String nombres;
	
	@Column(length = 100, nullable = false)
	private String apellidos;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo", nullable = false)
	private TipoDocumento tipoDocumento;
	
	@Column(length = 10, nullable = false)
	private String numeroDocumento;
	
	@Column(length = 100, nullable = false)
	private String correoElectronico;
	
	@Column(length = 10, nullable = false)
	private String telefono;
	
	public Usuario() {}

	public Usuario(String id, String nombres, String apellidos, TipoDocumento tipoDocumento, String numeroDocumento,
			String correoElectronico, String telefono) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}