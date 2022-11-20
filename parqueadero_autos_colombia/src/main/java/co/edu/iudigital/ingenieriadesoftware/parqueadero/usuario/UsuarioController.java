package co.edu.iudigital.ingenieriadesoftware.parqueadero.usuario;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Registro;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.TipoDocumento;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Usuario;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.TipoDocumentoRepositorio;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
	
	@Autowired
	private TipoDocumentoRepositorio tdr;
	
	@Autowired
	private UsuarioRepositorio ur;
	
	
	@PostMapping("/crearUsuario")
	public ResponseEntity<String> registrarEntrada(@RequestBody Usuario u) {
		Optional<Usuario> u2 = ur.findById(u.getId());
		if (u2.isEmpty()) {
			try {
				ur.save(u);
			}catch (Exception e) {
				return new ResponseEntity<String>("{ \"mensaje\" : \"" + e.getMessage() + "\" }", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<String>("{ \"mensaje\" : \"exito\" }", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("{ \"mensaje\" : \"El usuario ya existe\" }", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/tiposDocumento")
	public List<TipoDocumento> getTiposDocumento(){		
		return tdr.findAll();
	}
	
	@GetMapping("/todosUsuarios")
	public List<Usuario> getTodosUsuarios(){		
		return ur.findAll();
	}

}
