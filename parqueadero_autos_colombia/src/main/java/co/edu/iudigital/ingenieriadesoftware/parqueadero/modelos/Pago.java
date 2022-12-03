package co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private long id;
	
	@Column(length = 6)
	@Getter @Setter
	private String placa;
	
	@Getter @Setter
	private Date fecha;
	
	@Getter @Setter
	private long estado;
	
	@Getter @Setter
	private double valor;

}
