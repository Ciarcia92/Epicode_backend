package com.example.week.project.demo.week.project1.spring.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.week.project.demo.week.project1.spring.entities.Edificio;
import com.example.week.project.demo.week.project1.spring.entities.Postazione;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository edifRepo;
	
	public void insert(Edificio p) {
	
		try {
			edifRepo.save(p);
			System.out.println("edificio inserito correttamente");
		} catch(Exception e) {
			System.out.println("errore nell'inserimento");
		}
	}
	
	public List<Edificio> getAll() {
		return edifRepo.findAll();
	}
	
	public Optional<Edificio> getById(Long id) {
		return edifRepo.findById(id);
	}
	
}
