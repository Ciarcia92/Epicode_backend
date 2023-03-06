package entities;

import java.time.LocalDate;

import utils.JpaUtil;

public class EventoDAO extends JpaUtil {
	
	public static void inserisciEvento(String titolo, LocalDate data, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
		
		try {
			Evento ev = new Evento();
			ev.setDataEvento(data);
			ev.setTitolo(titolo);
			ev.setDescrizione(descrizione);
			ev.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
			ev.setTipoEvento(tipoEvento);
			
			
			t.begin();
			em.persist(ev);
			t.commit();
			
			System.out.println("Evento inserito correttamente");
		} catch (Exception e) {
			System.out.println("ERRORE durante l'insermento");
		}
	}
	
	public static void getEventoById(int id) {
		
		Evento ev = em.find(Evento.class, id);
		
		
		if( ev == null ) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return;
		}
		
		System.out.println( "Dati evento #" + id );
		System.out.printf(  
			"evento: %s | Data: %s | Descrizione: %s | tipo evento: %s | numero massimo partecipanti: %d",
			ev.getTitolo(), ev.getDataEvento(), ev.getDescrizione(), ev.getTipoEvento(), ev.getNumeroMassimoPartecipanti()
		);
	}
	
	public static void updateEvento(int id, String titolo, LocalDate data, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
		Evento ev = getEvento(id);
		if( ev == null ) return;
		
		try {
		
			ev.setDataEvento(data);
			ev.setTitolo(titolo);
			ev.setDescrizione(descrizione);
			ev.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
			ev.setTipoEvento(tipoEvento);
			
			
			t.begin();
			em.persist(ev);
			t.commit();
			
			System.out.println("L'evento con l'id " + id + "è stato aggiornato ");
		} catch (Exception e) {
			System.out.println("ERRORE durante l aggiornamento");
		}
		
	}

	public static Evento getEvento(int id) {
		Evento ev = em.find(Evento.class, id);
		
		if( ev == null ) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return null;
		} return ev;
	}
	
	
	public static void deleteEvento(int id) {
Evento ev = em.find(Evento.class, id);
		
		if( ev == null ) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return;
		} 
		
		t.begin();
		em.remove(ev);
		t.commit();
		
		System.out.println("l'evento con id: " + id + " è stato eliminato");
	}
	

}
