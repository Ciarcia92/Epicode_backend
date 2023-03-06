package main;

import java.time.LocalDate;

import entities.Evento;
import entities.EventoDAO;
import entities.TipoEvento;

public class main extends EventoDAO {

	public static void main(String[] args) {
		
			boolean inserisciEvento = false;
			boolean aggiornaEvento = false;
			boolean getEvento = false;
			boolean eliminaEvento = true;
			
		if(inserisciEvento) {
			inserisciEvento("partita pallavolo", LocalDate.parse("2022-02-02"), "semifinale", TipoEvento.PRIVATO, 600);
			inserisciEvento("partita", LocalDate.parse("2022-02-02"), "finale", TipoEvento.PUBBLICO, 5000);
			inserisciEvento("partita pallone", LocalDate.parse("2022-02-02"), "semifinale", TipoEvento.PUBBLICO, 6000);
			inserisciEvento("partita pallavolo", LocalDate.parse("2022-02-02"), "semifinale", TipoEvento.PRIVATO, 600);
			inserisciEvento("partita basket", LocalDate.parse("2022-02-02"), "semifinale", TipoEvento.PUBBLICO, 200);
			inserisciEvento("partita pallone", LocalDate.parse("2022-02-02"), "semifinale", TipoEvento.PUBBLICO, 6000);

		}
		
		if(aggiornaEvento) {
			updateEvento(1, "partita basket", LocalDate.parse("2022-02-02"), "semifinale", TipoEvento.PUBBLICO, 200);
		}
		
		if(getEvento) {
			getEventoById(2);
		}
		
		if(eliminaEvento) {
			deleteEvento(3);
		}
	}

}
