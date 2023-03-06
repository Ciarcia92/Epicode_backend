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
import week_project_4.wp4.entities.StatoDispositivo;
import week_project_4.wp4.entities.TipoDispositivo;
import week_project_4.wp4.repo.DispositivoRepo;
import week_project_4.wp4.services.DaoService;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

	@Autowired
	DaoService ds;

	@Autowired
	DispositivoRepo dr;

	@GetMapping
	public ResponseEntity<List<Dispositivo>> getDispositivi() {
		List<Dispositivo> dispositivi = ds.getAllDisp();
		if(!dispositivi.isEmpty()) {
			return new ResponseEntity<>(dispositivi, HttpStatus.OK);
		} else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Dispositivo> getDispositivo(@PathVariable int id) {
		Optional<Dispositivo> disp = ds.getDispositivoById(id);
	    if (disp.isPresent()) {
	        return new ResponseEntity<>(disp.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("tipo/{tipo}")
	public ResponseEntity <List<Dispositivo>> trovaPerTipo(@PathVariable TipoDispositivo tipo) {
		List<Dispositivo> dispositivi = dr.trovaPerTipo(tipo);
		if(!dispositivi.isEmpty()) {
			return new ResponseEntity<>(dispositivi, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("stato/{stato}")
	public ResponseEntity <List<Dispositivo>> trovaPerStato(@PathVariable StatoDispositivo stato) {
		List<Dispositivo> dispositivi = dr.trovaPerStato(stato);
		if(!dispositivi.isEmpty()) {
			return new ResponseEntity<>(dispositivi, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/aggiungi-dispositivo")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity <Dispositivo> aggiungiDispositivo(@RequestBody Dispositivo d) {
		Dispositivo disp = ds.saveDispositivo(d);
		
		return new ResponseEntity<>(disp, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/elimina-dispositivo/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> eliminaDispositivo(@PathVariable int id) {
		Optional<Dispositivo> disp = ds.getDispositivoById(id);
		if(!disp.isPresent()) {
			return new ResponseEntity<>("dispositivo non trovato", HttpStatus.NOT_FOUND);
		} else {
			Dispositivo d = disp.get();
			ds.eliminaDispositivo(d);
		} return new ResponseEntity<>("dispositivo eliminato", HttpStatus.OK);
	}
	
	@PutMapping("/update-dispositivo/{id}")
	public ResponseEntity<Dispositivo> updateUtente(@PathVariable int id, @RequestBody Dispositivo d) {
	    Optional<Dispositivo> disp =ds.getDispositivoById(id);
	    if (disp.isPresent()) {
	    	Dispositivo updatedDisp = ds.updateDispositivo(id, d);
	        return new ResponseEntity<>(updatedDisp, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
