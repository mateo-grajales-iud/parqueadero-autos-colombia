package co.edu.iudigital.ingenieriadesoftware.parqueadero.vehiculo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.TipoVehiculo;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Usuario;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Vehiculo;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.TipoVehiculoRepositorio;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.VehiculoRepositorio;

@RestController
@RequestMapping("api/vehiculo")
public class VehiculoController {
	
	@Autowired
	private TipoVehiculoRepositorio tvr;
	
	@Autowired
	private VehiculoRepositorio vr;
	
	@Autowired
	private VehiculoComponent vc;
	
	@GetMapping("tiposVehiculo")
	public List<TipoVehiculo> getTiposVehiculo(){
		return tvr.findAll();
	}
	
	@GetMapping("todosVehiculos")
	public List<Vehiculo> getVehiculos(){
		return vr.findAll();
	}
	
	@PostMapping("/crearVehiculo")
	public ResponseEntity<String> registrarEntrada(@RequestBody Vehiculo v) {
		Optional<Vehiculo> v2 = vr.findById(v.getPlaca());
		if (v2.isEmpty()) {
			try {				
				vr.save(v);
			}catch (Exception e) {
				return new ResponseEntity<String>("{ \"mensaje\" : \"" + e.getMessage() + "\" }", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<String>("{ \"mensaje\" : \"exito\" }", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("{ \"mensaje\" : \"El vehiculo ya existe\" }", HttpStatus.BAD_REQUEST);
		}
		
	}
}
