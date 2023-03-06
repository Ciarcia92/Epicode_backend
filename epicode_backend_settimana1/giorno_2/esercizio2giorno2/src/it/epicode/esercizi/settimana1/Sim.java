package it.epicode.esercizi.settimana1;

public class Sim {

	private String numeroTelefono;
	private double creditoDisponibile;
	private Chiamata[] listaChiamate;
	
	public Sim(String numero) {
		this.creditoDisponibile = 0;
		this.listaChiamate = new Chiamata[5];
		this.numeroTelefono = numero;
	}
	
	public String getNumeroDiTelefono() {
		return numeroTelefono;
	}
	
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	public double getCrediDisponibile() {
		return creditoDisponibile;
	}
	
	public void setCreditoDisponibile(double creditoDisponibile) {
		this.creditoDisponibile = creditoDisponibile;
	}
	public Chiamata[] getListaChiamate() {
		return listaChiamate;
	}
	public void setListaChiamate(Chiamata[] listaChiamate) {
		this.listaChiamate = listaChiamate;
	}
	
	public void stampaDati() {
		System.out.println("numero: " + this.numeroTelefono);
		System.out.println("credito: " + this.creditoDisponibile);
		System.out.println("lista chiamate: " + this.listaChiamate);
	}
} 
