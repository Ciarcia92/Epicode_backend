package week_project_4.wp4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import week_project_4.wp4.entities.Utente;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Integer> {

}
