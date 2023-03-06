package com.example.week.project.demo.week.project1.spring.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.week.project.demo.week.project1.spring.entities.Utente;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepo;

	
	public void insert(Utente p) {
		
		try {
			utenteRepo.save(p);
			System.out.println("utente inserito correttamente");
		} catch (Exception e) {
			System.out.println("errore nell'inserimento");
		}
	}

	public List<Utente> getAll() {
		return utenteRepo.findAll();
	}

	public Optional<Utente> getById(Long id) {
		return utenteRepo.findById(id);
	}
}
