package week_project_4.wp4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import week_project_4.wp4.entities.Dispositivo;
import week_project_4.wp4.entities.StatoDispositivo;
import week_project_4.wp4.entities.TipoDispositivo;

@Repository
public interface DispositivoRepo extends JpaRepository<Dispositivo, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM Dispositivo WHERE tipo = :tipo")
	List<Dispositivo> trovaPerTipo(@Param("tipo") TipoDispositivo tipo);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM Dispositivo WHERE stato= :stato")
	List<Dispositivo> trovaPerStato(@Param("stato") StatoDispositivo stato);
	
	
}
