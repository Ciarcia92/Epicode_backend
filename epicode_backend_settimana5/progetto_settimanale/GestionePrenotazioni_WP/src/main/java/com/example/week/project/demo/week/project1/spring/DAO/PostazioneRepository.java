package com.example.week.project.demo.week.project1.spring.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.week.project.demo.week.project1.spring.entities.Postazione;
import com.example.week.project.demo.week.project1.spring.entities.Tipo;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	@Query("SELECT * FORM postazioni p WHERE p.tipo = :tipo")
	List<Postazione> findByTipo(@Param("tipo") Tipo tipo);
}
