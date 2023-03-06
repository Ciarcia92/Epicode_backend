package week_project_4.wp4.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import week_project_4.wp4.entities.Dispositivo;
import week_project_4.wp4.entities.Utente;
import week_project_4.wp4.repo.UtenteRepo;
import week_project_4.wp4.services.DaoService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	DaoService ds;

	@Autowired
	UtenteRepo ur;
	
	@GetMapping
	public ResponseEntity<List<Utente>> getUtenti() {
		List<Utente> utenti = ds.getAllUt();
		if(!utenti.isEmpty()) {
			return new ResponseEntity<>(utenti, HttpStatus.OK);
		} else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Utente> getUtente(@PathVariable int id) {
		Optional<Utente> ut = ds.getUtenteById(id);
	    if (ut.isPresent()) {
	        return new ResponseEntity<>(ut.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	

	@PostMapping("/aggiungi-utente")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity <Utente> aggiungiUtente(@RequestBody Utente u) {
		Utente ut = ds.saveUtente(u);
		
		return new ResponseEntity<>(ut, HttpStatus.CREATED);
	}
	

	@DeleteMapping("/elimina-utente/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> eliminaUtente(@PathVariable int id) {
		Optional<Utente> ut = ds.getUtenteById(id);
		if(!ut.isPresent()) {
			return new ResponseEntity<>("utente non trovato", HttpStatus.NOT_FOUND);
		} else {
			Utente u = ut.get();
			ds.eliminaUtente(u);
		} return new ResponseEntity<>("utente eliminato", HttpStatus.OK);
	}
	
	@PutMapping("/update-utente/{id}")
	public ResponseEntity<Utente> updateUtente(@PathVariable int id, @RequestBody Utente u) {
	    Optional<Utente> utente = ds.getUtenteById(id);
	    if (utente.isPresent()) {
	    	Utente updatedUtente = ds.updateUtente(id, u);
	        return new ResponseEntity<>(updatedUtente, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
