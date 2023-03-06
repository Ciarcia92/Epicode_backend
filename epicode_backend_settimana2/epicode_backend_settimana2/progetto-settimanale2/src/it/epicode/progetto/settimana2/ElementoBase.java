package it.epicode.progetto.settimana2;

import java.util.HashSet;
import java.util.Set;

public abstract class ElementoBase {


    protected String titolo;
    protected int annoPubblicazione;
    protected int pagine;
    protected static Set<Integer> ISBNset = new HashSet<>();
    protected int ISBN;
	
	public ElementoBase() {
		
	}

	//GETTER
	public String getTitolo() {
		return titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}


	public int getPagine() {
		return pagine;
	}
	
	public int getISBN() {
		return ISBN;
	}


	//SETTER
	public void setTitolo(String titolo) {
	    if(titolo.length() < 2) {
	        throw new IllegalArgumentException("Il titolo deve avere almeno 2 caratteri!");
	    }
	    this.titolo = titolo;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
	    if(annoPubblicazione <= 0) {
	        throw new IllegalArgumentException("l'anno di pubblicazione non può essere 0 o minore");
	    }
	    this.annoPubblicazione = annoPubblicazione;
	}

	public void setPagine(int pagine) {
		if(pagine<=0) {
			 throw new IllegalArgumentException("il numero di pagine deve essere superiore a 0");
			
		}
		this.pagine = pagine;	
		
	}

	 public void setISBN(int ISBN) {
	        if(ISBNset.contains(ISBN)){
	            throw new IllegalArgumentException("ISBN gia presente, inserirne un'altro");
	        }
	        ISBNset.add(ISBN);
	        this.ISBN = ISBN;
	    }
	 
}
