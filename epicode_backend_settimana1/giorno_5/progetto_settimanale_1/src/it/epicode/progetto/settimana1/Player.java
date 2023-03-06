package it.epicode.progetto.settimana1;

import java.util.Scanner;

public class Player {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
	
		
		Video v1 = new Video();
		
		Audio a1 = new Audio();
		
		Immagine immagine1 = new Immagine();
		
		Video v2 = new Video();
		
		Audio a2 = new Audio();
	
	
		
		//RICEZIONE DATI PRIMA ISTANZA: video
		
		System.out.println("Inserisci il titolo del video v1");
		String tit1= scanner.next();
		v1.setTitolo(tit1);
		
		System.out.println("inserisci il volume per video v1");
		int vol1 = scanner.nextInt();
		v1.setVolume(vol1);
		
		System.out.println("inserisci la durata di video v1");
		int dur1 = scanner.nextInt();
		v1.setDurata(dur1);
		
		System.out.println("inserisci la luminosita di video v1");
		int l1 = scanner.nextInt();
		v1.setLuminosita(l1);
		v1.getLuminosita();

		//RICEZIONE DATI SECONDA ISTANZA: audio
	
		System.out.println("Inserisci il titolo dell audio a1");
		String tit2= scanner.next();
		a1.setTitolo(tit2);
		
		System.out.println("inserisci il volume dell audio a1");
		int vol2 = scanner.nextInt();
		a1.setVolume(vol2);
		
		System.out.println("inserisci la durata dell audio a1");
		int dur2 = scanner.nextInt();
		a1.setDurata(dur2);
		
		//RICEZIONE DATI TERZA ISTANZA: immagine

		System.out.println("Inserisci il titolo dell immagine");
		String titImm= scanner.next();
		immagine1.setTitolo(titImm);
		
		System.out.println("inserisci la luminosita dell immagine");
		int lum = scanner.nextInt();
		immagine1.setLuminosita(lum);
		
		//RICEZIONE DATI QUARTA ISTANZA: video
		
		System.out.println("Inserisci il titolo del video v2");
		String titVid= scanner.next();
		v2.setTitolo(titVid);
		
		System.out.println("inserisci il volume per video v2");
		int volVid = scanner.nextInt();
		v2.setVolume(volVid);
		
		System.out.println("inserisci la durata di video v2");
		int durVid = scanner.nextInt();
		v2.setDurata(durVid);
		
		System.out.println("inserisci la luminosita di video v2");
		int lVid = scanner.nextInt();
		v2.setLuminosita(lVid);
		v2.getLuminosita();
		
		
		//RICEZIONE DATI QUINTA ISTANZA: audio

		System.out.println("Inserisci il titolo dell audio a2");
		String titAud= scanner.next();
		a2.setTitolo(titAud);
		
		System.out.println("inserisci il volume dell audio a2");
		int volAud = scanner.nextInt();
		a2.setVolume(volAud);
		
		System.out.println("inserisci la durata dell audio a2");
		int durAud = scanner.nextInt();
		a2.setDurata(durAud);
		
		
		//OGGETTO DA ESEGUIRE
		int riproduci;
		do {
			System.out.println("Inserisci un numero da 1 a 5 per riprodurre gli elementi multimediali oppure 0 per interrompere la riproduzione");
			riproduci = scanner.nextInt();
			switch(riproduci) {
			case 0: 
				System.out.println("Riproduzione terminata");
				scanner.close();
				break;
			case 1: 
				v1.play();
				break;
			case 2: 
				a1.play();
				break;
			case 3: 
				immagine1.show();
				break;
			case 4: 
				v2.play();
				break;
			case 5: 
				a2.play();
				break;
				
				default:
					System.out.println("Hai inserito un numero sbaliato!");
				break;
			}	
		} while (riproduci != 0);
		
		
		
	}
/*
	public static void creaVideo(Video v, Scanner scanner) {
	    System.out.println("Inserisci il titolo del video: ");
	    String titolo = scanner.nextLine();
	    v.setTitolo(titolo);

	    System.out.println("Inserisci il volume del video: ");
	    int volume = scanner.nextInt();
	    v.setVolume(volume);

	    System.out.println("Inserisci la durata del video: ");
	    int durata = scanner.nextInt();
	    v.setDurata(durata);
	    
	    System.out.println("Inserisci la luminosità del video: ");
	    int luminosita = scanner.nextInt();
	    v.setLuminosita(luminosita);
	}
	
	public static void creaAudio(Audio a, Scanner scanner) {
	    System.out.println("Inserisci il titolo dell'audio: ");
	    String titolo = scanner.nextLine();
	    a.setTitolo(titolo);

	    System.out.println("Inserisci il volume dell'audio: ");
	    int volume = scanner.nextInt();
	    a.setVolume(volume);

	    System.out.println("Inserisci la durata dell'audio: ");
	    int durata = scanner.nextInt();
	    a.setDurata(durata);
	}
	
	public static void creaImmagine(Immagine i, Scanner scanner) {
	    System.out.println("Inserisci il titolo dell'immagine: ");
	    String titolo = scanner.nextLine();
	    i.setTitolo(titolo);

	    System.out.println("Inserisci la luminosità dell'immagine: ");
	    int luminosita = scanner.nextInt();
	    i.setLuminosita(luminosita);
	}
	*/
}
