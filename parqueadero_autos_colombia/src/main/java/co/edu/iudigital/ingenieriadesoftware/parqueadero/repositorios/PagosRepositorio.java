package co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Pago;

public interface PagosRepositorio extends CrudRepository<Pago, Long>{
	
	public List<Pago> findAllByPlaca(String placa);
	
	public List<Pago> findAll();
	
	public List<Pago> findAllByEstado(long estadoPago);
	
	@Procedure
	public List<Pago> generar_facturas();

}
