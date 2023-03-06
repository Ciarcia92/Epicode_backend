package it.epicode.progetto.settimana2;

import java.util.Set;

public class Rivista extends ElementoBase {

	
	private Periodicita periodicita;
	
	
	public Rivista() {	
	}

	
	//GETTER
	

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	
	
	//SETTER
	
	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	

	  @Override
	    public String toString() {
	    	return "Titolo: " + titolo + ", periodicita: " + periodicita + ", anno di pubblicazione: " + annoPubblicazione + ", ISBN: " + ISBN;
	    }


}
