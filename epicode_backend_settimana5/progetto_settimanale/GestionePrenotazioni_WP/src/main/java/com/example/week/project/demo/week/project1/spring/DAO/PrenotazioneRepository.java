package com.example.week.project.demo.week.project1.spring.DAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.week.project.demo.week.project1.spring.entities.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long>{

	@Query("SELECT * FROM prenotazioni WHERE data = :data AND utente_id = :id")
	List<Prenotazione> findByDataeId(@Param("data") LocalDate data, @Param("id") long id);
	
	@Query("SELECT * FROM prenotazioni WHERE postazione_id = :id AND data = :data")
	List<Prenotazione> findByPostazioneData(@Param("id") long id, @Param("data") LocalDate data);
	
}
