package co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.TipoDocumento;

public interface TipoDocumentoRepositorio extends CrudRepository<TipoDocumento, String>{
	
	public List<TipoDocumento> findAll();
	
	public TipoDocumento findByTipo(String tipo);

}
