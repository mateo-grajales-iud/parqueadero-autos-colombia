package co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos;

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
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_placa", nullable = true)
	private Vehiculo vehiculo;
	
	public Celda() {}

	public Celda(long id, Vehiculo vehiculo) {
		this.id = id;
		this.vehiculo = vehiculo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setPlaca(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}	

}
