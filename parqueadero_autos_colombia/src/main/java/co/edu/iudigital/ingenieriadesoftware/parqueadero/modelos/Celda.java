package co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Celda {
	
	@Id
	private long id;
	
	@Column(length = 6, nullable = true)
	private String vehiculo;
	
	public Celda() {}

	public Celda(long id, String vehiculo) {
		this.id = id;
		this.vehiculo = vehiculo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setPlaca(String vehiculo) {
		this.vehiculo = vehiculo;
	}	

}
