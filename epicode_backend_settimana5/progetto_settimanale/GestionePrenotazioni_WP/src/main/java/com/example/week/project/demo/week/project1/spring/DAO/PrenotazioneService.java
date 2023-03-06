package com.example.week.project.demo.week.project1.spring.DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.week.project.demo.week.project1.spring.entities.Postazione;
import com.example.week.project.demo.week.project1.spring.entities.Prenotazione;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazRepo;
	
	public void insert(Prenotazione p) {
		try {
			prenotazRepo.save(p);
			System.out.println("prenotazione inserita correttamente");
		} catch(Exception e) {
			System.out.println("errore nell'inserimento");
		}	
	}
	
	public List<Prenotazione> findByDataAndPostazione(Postazione postazione, LocalDate data) {
		return prenotazRepo.findAll().stream()
				.filter(p -> p.getPostazione().equals(postazione) && p.getData().equals(data))
                .collect(Collectors.toList());
	}
	
	public Optional<Prenotazione> getById(Long id) {
		return prenotazRepo.findById(id);
	}
	
}
