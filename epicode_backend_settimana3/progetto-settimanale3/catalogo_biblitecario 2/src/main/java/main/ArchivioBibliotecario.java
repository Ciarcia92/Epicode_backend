package main;

import java.time.LocalDate;

import entities.Genere;
import entities.Libro;
import entities.Periodicita;
import entities.Prestito;
import entities.Rivista;
import entities.Utente;
import entities.DAO.ElementoLetterarioDAO;
import entities.DAO.PrestitoDAO;
import entities.DAO.UtenteDAO;

public class ArchivioBibliotecario {

	public static void main(String[] args) {
		Libro l1 = salvaLibro();
		Rivista r1 = salvaRivista();
		Utente u1 = salvaUtente();
		Prestito prestitoInCorso = salvaPrestitoCorrente(u1, l1);
		Prestito prestitoScaduto = salvaPrestitoScaduto(u1, r1);
				
	}
	

	private static Libro salvaLibro() {
		Libro l1 = new Libro();
		l1.setAnnoPubblicazione(1992);
		l1.setAutore("herbert");
		l1.setTitolo("DUNE");
		l1.setGenere(Genere.FANSTASCIENZA);
		l1.setISBN(2134);
		l1.setPagine(200);

		ElementoLetterarioDAO elDAO = new ElementoLetterarioDAO();
		elDAO.save(l1);
		return l1;
	}

	private static Rivista salvaRivista() {
		Rivista r1 = new Rivista();
		r1.setAnnoPubblicazione(3000);
		r1.setISBN(3412);
		r1.setPagine(70);
		r1.setPeriodicita(Periodicita.MENSILE);
		r1.setTitolo("rivistone");
		

		ElementoLetterarioDAO elDAO = new ElementoLetterarioDAO();
		elDAO.save(r1);
		return r1;
	}

	private static Utente salvaUtente() {
		Utente u1 = new Utente();
		u1.setCognome("vardi");
		u1.setNome("marco");
		u1.setDataNascita(LocalDate.parse("2022-12-01"));
		u1.setNumTessera(1112);
		
		UtenteDAO utDAO = new UtenteDAO();
		utDAO.save(u1);
		return u1;
		
	}

	private static Prestito salvaPrestitoCorrente(Utente u1, Libro l1) {
		Prestito prestitoInCorso = new Prestito();
		prestitoInCorso.setDataInizioPrestito(LocalDate.parse("2023-01-01"));
		prestitoInCorso.setDataRestituzionePrevista(LocalDate.parse("2023-03-01"));
		prestitoInCorso.setDataRestituzioneEffettiva(LocalDate.parse("2023-02-10"));
		prestitoInCorso.setElementoPrestato(l1);
		
		PrestitoDAO prDAO = new PrestitoDAO();
		prDAO.save(prestitoInCorso);
		return prestitoInCorso;
		
	}

	private static Prestito salvaPrestitoScaduto(Utente u1, Rivista r1) {
		Prestito prestitoScaduto = new Prestito();
		prestitoScaduto.setDataInizioPrestito(LocalDate.parse("2023-01-10"));
		prestitoScaduto.setDataRestituzionePrevista(LocalDate.parse("2023-01-27"));
		prestitoScaduto.setElementoPrestato(r1);
		
		
		PrestitoDAO prDAO = new PrestitoDAO();
		prDAO.save(prestitoScaduto);
		
		
		return prestitoScaduto;
	}

}
