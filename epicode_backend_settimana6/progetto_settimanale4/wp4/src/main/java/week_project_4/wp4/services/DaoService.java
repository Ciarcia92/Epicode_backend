package week_project_4.wp4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import week_project_4.wp4.entities.Dispositivo;
import week_project_4.wp4.entities.Ruolo;
import week_project_4.wp4.entities.Utente;
import week_project_4.wp4.repo.DispositivoRepo;
import week_project_4.wp4.repo.RuoloRepo;
import week_project_4.wp4.repo.UtenteRepo;

@Service
public class DaoService {

	@Autowired
	private UtenteRepo ur;

	@Autowired
	private RuoloRepo rr;

	@Autowired
	private DispositivoRepo dr;
	
	//------------------UTENTE-----------------//
	
	public List<Utente> getAllUt() {
		return ur.findAll();
	}
	
	public Optional<Utente> getUtenteById(int id) {
		return ur.findById(id);
	}
	
	public Utente saveUtente(Utente obj) {
		ur.save(obj);
		System.out.println("Dispositivo inserito con successo");
		return obj;
	}
	
	public void stampaUtenti(List<Utente> u) {
		for(Utente ut : u) {
			System.out.println(ut);
		}
	}
	
	public void eliminaUtente(Utente u) {
		ur.delete(u);
	}
	
	public Utente updateUtente(int id, Utente u) {
		Optional <Utente> aggiornaUt = ur.findById(id);
		  if (aggiornaUt.isPresent()) {
	        	Utente utenteAggiornato = aggiornaUt.get();
	        	utenteAggiornato.setFullname(u.getFullname());
	        	utenteAggiornato.setEmail(u.getEmail());
	        	utenteAggiornato.setUsername(u.getUsername());
	        	utenteAggiornato.setPassword(u.getPassword());
	            return ur.save(utenteAggiornato);
	        } else {
	            return null;
	        }    
	}
	
	//------------------DISPOSITIVO-----------------//
	
	public List<Dispositivo> getAllDisp() {
		return dr.findAll();
	}
	
	public Optional<Dispositivo> getDispositivoById(int id) {
		return dr.findById(id);
	}
	
	public Dispositivo saveDispositivo(Dispositivo obj) {
		dr.save(obj);
		System.out.println("Dispositivo inserito con successo");
		return obj;
	}
	
	public void stampaDispositivi(List<Dispositivo> d) {
		for(Dispositivo disp : d) {
			System.out.println(disp);
		}
	}
	
	public void eliminaDispositivo(Dispositivo d) {
		dr.delete(d);
	}
	
	public Dispositivo updateDispositivo(int id, Dispositivo d) {
		Optional <Dispositivo> aggiornaDisp = dr.findById(id);
		  if (aggiornaDisp.isPresent()) {
			  Dispositivo dispositivoAggiornato = aggiornaDisp.get();
			  dispositivoAggiornato.setDisp(d.getDisp());
			  dispositivoAggiornato.setTipo(d.getTipo());
	            return dr.save(dispositivoAggiornato);
	        } else {
	            return null;
	        }    
	}
	
	//------------------RUOLO-----------------//
	
	public Ruolo salvaRuolo(Ruolo obj) {
		return rr.save(obj);
	}
	
	
}
