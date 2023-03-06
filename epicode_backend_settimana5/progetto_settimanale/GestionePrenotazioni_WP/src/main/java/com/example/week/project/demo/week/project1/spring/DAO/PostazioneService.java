package com.example.week.project.demo.week.project1.spring.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.week.project.demo.week.project1.spring.entities.Postazione;
import com.example.week.project.demo.week.project1.spring.entities.Tipo;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneRepository postazRepo;
	
	public void insert(Postazione p) {
		try {
			postazRepo.save(p);
				System.out.println("postazione inserita correttamente");
			} catch(Exception e) {
				System.out.println("errore nell'inserimento");
			}
	}

	public void getByTipo(Tipo tipo) {
		postazRepo.findByTipo(tipo).forEach(e-> System.out.println(e.toString()));
	}
	
	public List<Postazione> getAll() {
		return postazRepo.findAll();
	}
	
	public void getByCitta(String citta) {
		List<Postazione> postazioni = postazRepo.findAll().stream().filter(e->e.getEdificio().getCitta().contains(citta)).toList();
		postazioni.forEach(e-> System.out.println(e.toString()));
	}
	
	public Optional<Postazione> getById(Long id) {
		return postazRepo.findById(id);
	}
	

}