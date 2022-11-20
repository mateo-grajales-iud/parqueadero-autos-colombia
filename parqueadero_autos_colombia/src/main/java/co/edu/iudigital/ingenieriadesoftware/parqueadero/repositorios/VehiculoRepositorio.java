package co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Vehiculo;

public interface VehiculoRepositorio extends CrudRepository<Vehiculo, String>{
	
	public List<Vehiculo> findAll();

}
