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
public class EstadoPago {
	
	@Id
	@Getter @Setter
	private long id;
	
	@Column(length = 20)
	@Getter @Setter
	private String descripcion;
	

}
