package it.epicode.progetto.settimana2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class Archivio {

	private static final String ENCODING = "utf-8";
	static String fileNameLibri = "libri.txt";
	static String fileNameRiviste = "riviste.txt";
	static File fileLibri = new File(fileNameLibri);
	static File fileRiviste = new File(fileNameRiviste);

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		/*
		 * nel main sono presenti sopo degli operatori condizionali che richiedono il
		 * tipo di operazione che si desidare fare e le chiamate alle rispettive
		 * funzioni. le funzioni sono definite fuori del main
		 */

		System.out.println("vuoi aggiungere un libro all'archivio o una rivista?");
		String crea = in.next();
		if (crea.equals("libro")) {
			creaLibro();
		} else if (crea.equals("rivista")) {
			creaRivista();
		} else {
			return;
		}

		System.out.println("vuoi fare le operazioni sui libri o sulle riviste?");
		String string = in.next();
		if (string.equals("libri")) {
			System.out.println("-----------------------------");
			System.out.println("puoi fare varie operazioni:");
			System.out.println(
					"puoi eliminare un libro dall'archivio, oppure eseguire una ricerca in base all' ISBN, anno di pubbblicazione o all'autore");
			System.out.println(
					"scrivi elimina per eliminare, per cercare scrivi ISBN, anno o autore, esci per uscire, oppure stampare tutta la lista di libri scrivendo stampa ");
			String cosaFare = in.next();
			switch (cosaFare) {
			case "elimina":
				eliminaLibro();
				break;
			case "ISBN":
				cercaIsbn();
				break;
			case "anno":
				cercaAnno();
				break;
			case "autore":
				cercaAutore();
				break;
			case "esci":
				break;
			}

		} else {
			System.out.println("-----------------------------");
			System.out.println("stai per fare operazioni sulle riviste");
			System.out.println(
					"puoi eliminare la rivista scrivendo elimina, anno per cercare in base all'anno di pubblicazione"
							+ " o ISBN o esci per uscire");
			String cosaFare = in.next();
			switch (cosaFare) {
			case "elimina":
				eliminaRivista();
				break;
			case "ISBN":
				cercaIsbnRivista();
				break;
			case "anno":
				cercaAnnoRivista();
				break;
			case "esci":
				break;
			}
		}

		////////////////////////////// SCRITTURA E LETTURA SU DISCO DEI LIBRI E DELLE
		////////////////////////////// RIVISTE////////////////////
		System.out.println("-----------------------------");
		System.out.println("scrivi sl per salvare su disco i libri, sr per salvare le riviste su disco");
		System.out.println("oppure ll  o lr per leggerli rispettivamente e stamparli in console");
		String cosaFare = in.next();
		switch (cosaFare) {
		case "sl":
			try {
				scriviLibriSuFile(listaLibri, true);
				System.out.println("hai salvato su disco il libro");
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			;
			break;
		case "sr":
			try {
				scriviRivisteSuFile(listaRiviste, true);
				System.out.println("hai salvato su disco la rivista");
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			;
			break;
		case "ll":
			try {
				leggiSuFile(fileLibri);
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			;
			break;
		case "lr":
			try {
				leggiSuFile(fileRiviste);
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			;
			break;
		case "esci":
			break;
		}

	}

	//////////////////////////////// RIVISTE//////////////////////////////7
	static List<Rivista> listaRiviste = new ArrayList<>();

	private static void creaRivista() {

		//////////////////////////////////// CREAZIONE ISTANZA RIVISTA
		Rivista r1 = new Rivista();

		System.out.println("inserisci il titolo della rivista");
		try {
			String titoloRivista = in.next();
			r1.setTitolo(titoloRivista);
		} catch (IllegalArgumentException e) {
			System.out.println("Il titolo della rivista non è valido: " + e.getMessage());
		}
		/*
		 * System.out.println("inserisci l'anno di pubblicazione della rivista"); int
		 * annRivista = 0; try { annRivista = Integer.parseInt(in.nextLine());
		 * r1.setAnnoPubblicazione(annRivista); } catch (IllegalArgumentException e) {
		 * System.out.println("L'anno di pubblicazione non è valido: " +
		 * e.getMessage()); }
		 */while (true) {
			System.out.println("inserisci l'anno di pubblicazione della rivista:");
			String input = in.nextLine();
			try {
				int annRivista = Integer.parseInt(input);
				r1.setAnnoPubblicazione(annRivista);
				break;
			} catch (NumberFormatException e) {
				System.out.println("L'anno di pubblicazione non è valido: " + e.getMessage());
			}
		}
		System.out.println("inserisci il numero di pagine della rivista");
		try {
			int pagineRivista = in.nextInt();
			r1.setPagine(pagineRivista);
		} catch (IllegalArgumentException e) {
			System.out.println("Il numero di pagine non è valido: " + e.getMessage());
		}

		System.out.println("inserisci il codice ISBN della rivista");
		try {
			int ISBNrivista = in.nextInt();
			r1.setISBN(ISBNrivista);
		} catch (IllegalArgumentException e) {
			System.out.println("Il codice ISBN non è valido: " + e.getMessage());
		}

		System.out.println("inserisci la periodicità della rivista: SETTIMANALE, MENSILE, SEMESTRALE");
		String period = in.next();

		switch (period) {
		case "SETTIMANALE":
			r1.setPeriodicita(Periodicita.SETTIMANALE);
			break;
		case "MENSILE":
			r1.setPeriodicita(Periodicita.MENSILE);
			break;
		case "SEMESTRALE":
			r1.setPeriodicita(Periodicita.SEMESTRALE);
			break;
		}

		////////////////// AGGIUNTA DELLA RIVISTA ALL'ARRAYLIST
		listaRiviste.add(r1);
	}

	private static void eliminaRivista() {

		/////////////////////////////////////////// ELIMINAZIONE DELLA RIVISTA IN BASE
		/////////////////////////////////////////// ALL'ISBN
		System.out.println("----------------------------------");
		System.out.println("scrivi l'ISBN della rivista da eliminare");
		int ISBNrivistaEl = in.nextInt();

		List<Rivista> rivistaStream0 = listaRiviste.stream().filter(r -> r.getISBN() == ISBNrivistaEl)
				.collect(Collectors.toList());

		listaLibri.remove(rivistaStream0);
	}

	private static void cercaIsbnRivista() {

		//////////////////////////////////////// 7// RICERCA DELL'ELEMENTO IN BASE
		//////////////////////////////////////// ALL'ISBN
		int ISBNrivistaCerca = in.nextInt();

		List<Rivista> rivisteStream1 = listaRiviste.stream().filter(r -> r.getISBN() == ISBNrivistaCerca)
				.collect(Collectors.toList());

		rivisteStream1.forEach(r -> System.out.println(r));

	}

	private static void cercaAnnoRivista() {

		///////////////////////////// RICERCA PER ANNO DI PUBBLICAZIONE
		System.out.println("----------------------------------");
		System.out.println("scrivi l'anno di pubblicazione del libro da cercare");
		int annoRicercaRivista = in.nextInt();

		List<Rivista> rivisteStream2 = listaRiviste.stream().filter(r -> r.getAnnoPubblicazione() == annoRicercaRivista)
				.collect(Collectors.toList());

		rivisteStream2.forEach(r -> System.out.println(r));
	}

	/////////////////// 7////////////////////////////////////
	/////////////////// LIBRI//////////////////////////////////

	static List<Libro> listaLibri = new ArrayList<>();

	private static void creaLibro() {

		///////////////////////////////////////////////////// CREAZIONE ISTANZA LIBRO
		Libro l1 = new Libro();

		System.out.println("inserisci il titolo del libro");
		try {
			String titoloLibro = in.next();
			l1.setTitolo(titoloLibro);
		} catch (IllegalArgumentException e) {
			System.out.println("Il titolo non è valido: " + e.getMessage());
		}

		System.out.println("inserisci l'autore del libro");
		try {
			String autoreLibro = in.next();
			l1.setAutore(autoreLibro);
		} catch (IllegalArgumentException e) {
			System.out.println("L'autore del libro non è valido: " + e.getMessage());
		}

		System.out.println("inserisci il genere del libro");
		try {
			String genereLibro = in.next();
			l1.setGenere(genereLibro);
		} catch (IllegalArgumentException e) {
			System.out.println("Il genere non è valido: " + e.getMessage());
		}

		System.out.println("inserisci l'anno di pubblicazione del libro");
		try {
			int annoLibro = in.nextInt();
			l1.setAnnoPubblicazione(annoLibro);
		} catch (NumberFormatException e) {
			System.out.println("l'anno di pubblicazione non è valido: " + e.getMessage());
		}
		System.out.println("inserisci il numero di pagine del libro");
		try {
			int pagineLibro = in.nextInt();
			l1.setPagine(pagineLibro);
		} catch (NumberFormatException e) {
			System.out.println("Il numero di pagine non è valido: " + e.getMessage());
		}

		System.out.println("inserisci il codice ISBN del libro");
		try {
			int ISBNlibro = in.nextInt();
			l1.setISBN(ISBNlibro);
		} catch (NumberFormatException e) {
			System.out.println("Il codice ISBN non è valido: " + e.getMessage());
		}

		/////////////////////////////////////////// AGGIUNTA DEL LIBRO ALLA LISTA
		listaLibri.add(l1);
	}

	private static void eliminaLibro() {

		////////////////////////////// ELIMINAZIONE DELLA RIVISTA IN BASE
		////////////////////////////// ALL'ISBN////////////////////////////////

		System.out.println("----------------------------------");
		System.out.println("scrivi l'ISBN della rivista da eliminare");
		int ISBNlibro = in.nextInt();

		List<Libro> libroStream0 = listaLibri.stream().filter(l -> l.getISBN() == ISBNlibro)
				.collect(Collectors.toList());

		listaLibri.remove(libroStream0);
	}

	private static void cercaIsbn() {

////////////////////////////////////////////////////RICERCA DELL'LIBRO IN BASE ALL'ISBN
		System.out.println("----------------------------------");
		System.out.println("scrivi l'ISBN del libro da cercare");
		int ISBNricerca = in.nextInt();

		List<Libro> libroStream = listaLibri.stream().filter(l -> l.getISBN() == ISBNricerca)
				.collect(Collectors.toList());

		libroStream.forEach(l -> System.out.println(l));
	}

	private static void cercaAnno() {

		///////////////////////////////////////// RICERCA PER ANNO DI PUBBLICAZIONE
		System.out.println("----------------------------------");
		System.out.println("scrivi l'anno di pubblicazione del libro da cercare");
		int annoRicerca = in.nextInt();

		List<Libro> libroStream2 = listaLibri.stream().filter(l -> l.getAnnoPubblicazione() == annoRicerca)
				.collect(Collectors.toList());

		libroStream2.forEach(l -> System.out.println(l));
	}

	private static void cercaAutore() {

		//////////////////////////////////////////// RICERCA IN BASE ALL'AUTORE
		System.out.println("----------------------------------");
		System.out.println("scrivi l'autore del libro da cercare");
		String autRicerca = in.next();

		List<Libro> libroStream1 = listaLibri.stream().filter(l -> l.getAutore() == autRicerca)
				.collect(Collectors.toList());

		libroStream1.forEach(l -> System.out.println(l));
	}

	//////////////////////////// METODO PER LA SCRITTURA SUL FILE
	//////////////////////////// libri.txt/////////////////////////////
	public static void scriviLibriSuFile(List<Libro> listaLibri, boolean append) throws IOException {
		StringBuilder scriviNelFile = new StringBuilder("");
		for (int i = 0; i < listaLibri.size(); i++) {
			scriviNelFile.append(listaLibri.get(i).toString() + System.lineSeparator());
		}
		String str = scriviNelFile.toString();
		FileUtils.writeStringToFile(fileLibri, str, ENCODING, append);
	}

	//////////////////////////// METEDO PER LA SCRITTURA SUL FILE
	//////////////////////////// riviste.txt///////////////////////////
	public static void scriviRivisteSuFile(List<Rivista> listaRiviste, boolean append) throws IOException {
		StringBuilder scriviNelFile = new StringBuilder("");
		for (int i = 0; i < listaRiviste.size(); i++) {
			scriviNelFile.append(listaRiviste.get(i).toString() + System.lineSeparator());
		}
		String str = scriviNelFile.toString();
		FileUtils.writeStringToFile(fileRiviste, str, ENCODING, append);
	}

	////////////////////////////// METODO PER LA LETTURA DEL FILE libri.txt O
	////////////////////////////// riviste.txt
	public static void leggiSuFile(File file) throws IOException {
		System.out.println(FileUtils.readFileToString(file, ENCODING));
	}

}
