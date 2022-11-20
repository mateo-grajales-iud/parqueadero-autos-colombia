package co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, String>{
	
	public List<Usuario> findAll();

}
