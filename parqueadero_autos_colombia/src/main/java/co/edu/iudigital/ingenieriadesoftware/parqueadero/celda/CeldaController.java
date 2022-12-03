package co.edu.iudigital.ingenieriadesoftware.parqueadero.celda;

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

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Celda;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Vehiculo;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.CeldasRepositorio;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.VehiculoRepositorio;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.vehiculo.VehiculoComponent;

@RestController
@RequestMapping("api/celda")
public class CeldaController {

	@Autowired
	private CeldasRepositorio cr;

	@Autowired
	private VehiculoRepositorio vr;

	@Autowired
	private CeldaComponent cc;

	@GetMapping("todasCeldas")
	public List<Celda> getCeldas() {
		return cr.findAll();
	}

	@PostMapping("crearCelda")
	public ResponseEntity<String> crearCelda(@RequestBody Celda c) {
		Optional<Celda> c2 = cr.findById(c.getId());
		if (c2.isEmpty()) {
			if (!c.getVehiculo().isBlank()) {
				c2 = cr.findByVehiculo(c.getVehiculo());
				if (c2.isPresent()) {
					return new ResponseEntity<String>("{ \"mensaje\" : \"El vehiculo ya esta asociado a una celda\" }",
							HttpStatus.BAD_REQUEST);
				}
			}
			if (c.getId() <= 0) {
				return new ResponseEntity<String>("{ \"mensaje\" : \"El ID debe ser mayor a 0\" }",
						HttpStatus.BAD_REQUEST);
			}
			try {
				cr.save(c);
			} catch (Exception e) {
				return new ResponseEntity<String>("{ \"mensaje\" : \"" + e.getMessage() + "\" }",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<String>("{ \"mensaje\" : \"exito\" }", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("{ \"mensaje\" : \"La celda ya existe\" }", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("asociarCelda")
	public ResponseEntity<String> asociarCelda(@RequestBody Celda c) {
		Optional<Celda> c2 = cr.findById(c.getId());
		if (c2.isEmpty()) {
			return new ResponseEntity<String>("{ \"mensaje\" : \"La celda no existe\" }", HttpStatus.BAD_REQUEST);
		} else {
			if (!c.getVehiculo().isBlank()) {
				Optional<Vehiculo> v2 = vr.findById(c.getVehiculo());
				if (v2.isEmpty()) {
					return new ResponseEntity<String>("{ \"mensaje\" : \"El vehiculo no existe\" }",
							HttpStatus.BAD_REQUEST);
				}
			}
			try {
				if (!c.getVehiculo().isBlank()) {
					c2 = cr.findByVehiculo(c.getVehiculo());
					if (c2.isPresent()) {
						Celda cAnterior = c2.get();
						cAnterior.setVehiculo(null);
						cr.save(cAnterior);
					}
				}
				if (c2.isPresent() && c2.get().getId() == c.getId()) {
					c2 = null;
				}
				if (!c.getVehiculo().isBlank()) {
					cc.validarPrimerAsociacion(c);
				}
				cr.save(c);
				return new ResponseEntity<String>("{ \"mensaje\" : \"exito\" }", HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("{ \"mensaje\" : \"" + e.getMessage() + "\" }",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

}
