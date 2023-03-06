package it.epicode.progetto.settimana1;

public abstract class ElementoMultimediale {

	 protected String titolo;
	 
	    public ElementoMultimediale() {
	    
	    }
	    public String getTitolo() {
	    	return titolo;
	    }
	    public void setTitolo(String titolo) {
	    	if(titolo.length() > 2) {
	    		this.titolo = titolo;
	    	} else { 
	    		System.out.println("Il titolo deve avere almeno 2 caratteri!");
	    		return;
	    	}
	    }
	}