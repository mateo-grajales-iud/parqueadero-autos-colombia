package co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registro")
@AllArgsConstructor
@NoArgsConstructor
public class Registro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	@Getter @Setter
	private long id;
	
	
	@Column(name = "PLACA", length = 6)
	@Getter @Setter
	private String placa;
	
	@Column(name = "FECHA")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Getter @Setter
	private Timestamp fecha;
	
	@Column(name = "TIPO")
	@Getter @Setter
	private long tipo;
	
}
