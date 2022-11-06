package co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "registro")
public class Registro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	
	@Column(name = "PLACA", length = 6)
	private String placa;
	
	@Column(name = "ENTRADA")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp entrada;
	
	@Column(name = "SALIDA")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp salida;
	
	public Registro() {
		
	}

	public Registro(long id, String placa, Timestamp entrada, Timestamp salida) {
		super();
		this.id = id;
		this.placa = placa;
		this.entrada = entrada;
		this.salida = salida;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Timestamp getEntrada() {
		return entrada;
	}

	public void setEntrada(Timestamp entrada) {
		this.entrada = entrada;
	}

	public Timestamp getSalida() {
		return salida;
	}

	public void setSalida(Timestamp salida) {
		this.salida = salida;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", placa=" + placa + ", entrada=" + entrada + ", salida=" + salida + "]";
	}

}
