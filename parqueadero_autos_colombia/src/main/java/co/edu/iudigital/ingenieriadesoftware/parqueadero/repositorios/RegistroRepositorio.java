package co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Registro;

public interface RegistroRepositorio extends JpaRepository<Registro, Long>{
	
	public List<Registro> findAllByFechaBetween(Timestamp inicio, Timestamp fin);
	
	public Registro findFirstByPlacaOrderByFechaDesc(String placa);
}
