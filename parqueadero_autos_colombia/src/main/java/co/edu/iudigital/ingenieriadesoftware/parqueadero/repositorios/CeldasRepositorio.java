package co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Celda;

public interface CeldasRepositorio extends CrudRepository<Celda, Long>{
	
	public List<Celda> findAll();
	
	public List<Celda> findAllByVehiculo(String id);
	
	public Optional<Celda> findByVehiculo(String vehiculo);

}
