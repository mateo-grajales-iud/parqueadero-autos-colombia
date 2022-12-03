package co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.TipoRegistro;

public interface TipoRegistroRepositorio extends CrudRepository<TipoRegistro, Long>{
	
	public TipoRegistro findById(long id);

}
