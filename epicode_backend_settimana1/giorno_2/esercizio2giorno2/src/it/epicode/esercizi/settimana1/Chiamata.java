package it.epicode.esercizi.settimana1;

public class Chiamata {
	private String numeroChiamato;
	private int durataMinuti;
	
	public Chiamata(String numeroChiamato, int durata) {
		this.durataMinuti = durata;
		this.numeroChiamato = numeroChiamato;
	}
	
	public String getNumeroChiamato() {
		return numeroChiamato;
	}
	
	public void setNumeroChiamato(String numeroChiamato) {
		this.numeroChiamato = numeroChiamato;
	}
	
	public int getDurataMinuti() {
		return durataMinuti;
	}
	public void setDurataMinuti (int durataMinuti) {
		this.durataMinuti = durataMinuti;
	}
}
