package it.epicode.progetto.settimana2;

import java.util.HashSet;
import java.util.Set;

public class Libro extends ElementoBase {

	private String autore;
	private String genere;
	
	
	
	public Libro () {
		
	}

	//GETTER
	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}
	
	

	//SETTER
	public void setAutore(String autore) {
		if(autore.length()<2) {
			throw new IllegalArgumentException("Il nome dell'autore deve avere almeno 2 caratteri!");
		}
			this.autore = autore;			
		
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	  @Override
	    public String toString() {
	    	return "Titolo: " + titolo + ", autore: " + autore + ", anno di pubblicazione: " + annoPubblicazione + ", genere: " + genere;
	    }


	
}
