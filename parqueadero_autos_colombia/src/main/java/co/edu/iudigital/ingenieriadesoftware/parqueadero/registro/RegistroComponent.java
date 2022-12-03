package co.edu.iudigital.ingenieriadesoftware.parqueadero.registro;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Registro;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.TipoRegistro;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.RegistroRepositorio;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.TipoRegistroRepositorio;

@Component
public class RegistroComponent {
	
	@Autowired
	private RegistroRepositorio rr;
	
	@Autowired
	private TipoRegistroRepositorio trr;
	
	public void registrarEntrada(Registro r) throws Exception{
		if (r.getPlaca() == null || r.getPlaca().isEmpty()) {
			throw new Exception("La placa no puede estar vacia");
		} else if (r.getPlaca().length() < 5 || r.getPlaca().length() > 6) {
			throw new Exception("La placa debe tener 5 o 6 digitos");
		} else if (r.getFecha() == null) {
			throw new Exception("La hora de entrada no puede estar vacia");
		}
		rr.save(r);
	}
	
	public void registrarSalida(Registro r) throws Exception{
		if (r.getPlaca() == null || r.getPlaca().isEmpty()) {
			throw new Exception("La placa no puede estar vacia");
		} else if (r.getPlaca().length() < 5 || r.getPlaca().length() > 6) {
			throw new Exception("La placa debe tener 5 o 6 digitos");
		} else if (r.getFecha() == null) {
			throw new Exception("La hora de salida no puede estar vacia");
		}
		Registro entrada = rr.findFirstByPlacaOrderByFechaDesc(r.getPlaca());
		TipoRegistro tr = trr.findById(entrada.getTipo());
		if (tr == null) {
			throw new Exception("Error en el ultimo registro");
		}
		rr.save(r);
	}
	
	public List<Registro> obtenerRegistros(Date fecha){
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		Timestamp t1 = new Timestamp(c.getTimeInMillis());
		c.add(Calendar.DAY_OF_MONTH, 1);
		Timestamp t2 = new Timestamp(c.getTimeInMillis());
		return rr.findAllByFechaBetween(t1, t2);
	}

}
