package co.edu.iudigital.ingenieriadesoftware.parqueadero.pagos;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Pago;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.TipoVehiculo;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.PagosRepositorio;

@RestController
@RequestMapping("api/pagos")
public class PagosController {

	@Autowired
	private PagosRepositorio pr;
	
	@Autowired
	private PagosComponent pc;
	
	@GetMapping("todosPagos")
	public List<Pago> getAll(){
		return pr.findAllByEstado(0);
	}
	
	@GetMapping("generar")
	@Transactional(readOnly = false)
	public List<Pago> generarPagos(){
		return pc.generarFactura();		
	}
	
	@PostMapping("pagar")
	public ResponseEntity<String> pagar(@RequestBody String body){
		try {
			Map<String, Object> json = new ObjectMapper().readValue(body, Map.class);
			pc.pagar(Long.parseLong((String) json.get("id")));
		} catch (Exception e) {
			return new ResponseEntity<String>("{ \"mensaje\" : \"" + e.getMessage() + "\" }", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("{ \"mensaje\" : \"exito\" }", HttpStatus.OK);
	}
}
