package co.edu.iudigital.ingenieriadesoftware.parqueadero.repositorios;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.iudigital.ingenieriadesoftware.parqueadero.modelos.Registro;

public interface RegistroRepositorio extends JpaRepository<Registro, Long>{
	
	public Registro findFirstByPlacaAndSalidaIsNullOrderByEntrada(String placa);
	
	@Query("SELECT r from Registro r WHERE r.entrada BETWEEN :inicio AND :fin OR r.salida BETWEEN :inicio AND :fin")
	public List<Registro> findAllByEntradaAndSalidaBetween(@Param("inicio") Timestamp inicio, @Param("fin") Timestamp fin);
}
