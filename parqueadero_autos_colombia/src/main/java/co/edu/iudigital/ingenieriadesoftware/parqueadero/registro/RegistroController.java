package co.edu.iudigital.ingenieriadesoftware.parqueadero.registro;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Registro;

@RestController()
@RequestMapping("api/registro")
public class RegistroController {
	
	@Autowired
	private RegistroComponent component;
	
	@PostMapping("/entrada")
	public ResponseEntity<String> registrarEntrada(@RequestBody Registro r) {
		try {
			component.registrarEntrada(r);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Entrada registrada", HttpStatus.OK);
	}
	
	@PostMapping("/salida")
	public ResponseEntity<String> registrarSalida(@RequestBody Registro r) {
		try {
			component.registrarSalida(r);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Salida registrada", HttpStatus.OK);
	}
	
	@GetMapping("/historial/{fecha}")
	public List<Registro> obtenerHistorial(@PathVariable("fecha") Date fecha){		
		return component.obtenerRegistros(fecha);
	}
	

}
