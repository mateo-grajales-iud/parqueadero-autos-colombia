package co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.TipoDocumento;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.TipoVehiculo;

public interface TipoVehiculoRepositorio extends CrudRepository<TipoVehiculo, String>{
	
	public List<TipoVehiculo> findAll();
	

}
