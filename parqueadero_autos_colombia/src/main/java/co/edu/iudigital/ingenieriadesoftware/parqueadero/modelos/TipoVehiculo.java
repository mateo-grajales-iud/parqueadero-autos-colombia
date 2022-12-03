package co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TipoVehiculo {
	
	@Id
	@Column(length = 2, nullable = false)
	@Getter @Setter
	private String tipo;
	
	@Column(length = 20, nullable = false)
	@Getter @Setter
	private String descripcion;
	
	@Getter @Setter
	private double valorMes;

}
