package co.edu.iudigital.ingenieriadesoftware.parqueadero.pagos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Pago;
import co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios.PagosRepositorio;

@Component
public class PagosComponent {
	
	@Autowired
	private PagosRepositorio pr;
	
	public List<Pago> generarFactura() {
		return pr.generar_facturas();
	}
	
	public void pagar(long id) throws Exception {
		Optional<Pago> p = pr.findById(id);
		if (p.isPresent()) {
			p.get().setEstado(1);
			pr.save(p.get());
		} else {
			throw new Exception("El pago no existe");
		}
	}

}
