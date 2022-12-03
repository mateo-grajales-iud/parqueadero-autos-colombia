package co.edu.iudigital.ingenieriadesoftware.parqueadero.vehiculo;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAmount;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Pago;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.TipoVehiculo;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Vehiculo;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.PagosRepositorio;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.TipoVehiculoRepositorio;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.VehiculoRepositorio;

@Component
public class VehiculoComponent {
	
	@Autowired
	private TipoVehiculoRepositorio tvr;
	
	@Autowired
	private VehiculoRepositorio vr;
	
	@Autowired
	private PagosRepositorio pr;

}
