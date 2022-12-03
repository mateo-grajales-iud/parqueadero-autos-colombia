package co.edu.iudigital.ingenieriadesoftware.parqueadero.celda;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Celda;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Pago;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.TipoVehiculo;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Vehiculo;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.CeldasRepositorio;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.PagosRepositorio;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.TipoVehiculoRepositorio;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.VehiculoRepositorio;

@Component
public class CeldaComponent {
	
	@Autowired
	private CeldasRepositorio cr;
	
	@Autowired
	private PagosRepositorio pr;
	
	@Autowired
	private TipoVehiculoRepositorio tvr;
	
	@Autowired
	private VehiculoRepositorio vr;
	
	public void validarPrimerAsociacion(Celda c) {
		List<Pago> pagos = pr.findAllByPlaca(c.getVehiculo());
		Vehiculo v = vr.findById(c.getVehiculo()).get();
		if (pagos.size() == 0) {
			TipoVehiculo tv = tvr.findById(v.getTipo()).get();
			Calendar hoy = Calendar.getInstance();
			Calendar finMes = Calendar.getInstance();
			Calendar inicioMes = Calendar.getInstance();
			finMes.add(Calendar.MONTH, 1);
			finMes.set(Calendar.DAY_OF_MONTH, 1);
			inicioMes.set(Calendar.DAY_OF_MONTH, 1);		
			long diasMes = Duration.between(inicioMes.toInstant(), finMes.toInstant()).toDays();
			long dias = diasMes - hoy.get(Calendar.DAY_OF_MONTH);
			double totalPagar = (dias * tv.getValorMes()) / diasMes;
			Pago p = new Pago();
			p.setEstado(0);
			p.setFecha(new java.sql.Date(hoy.getTimeInMillis()));
			p.setValor(totalPagar);
			p.setPlaca(v.getPlaca());
			pr.save(p);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		}
	}

}
