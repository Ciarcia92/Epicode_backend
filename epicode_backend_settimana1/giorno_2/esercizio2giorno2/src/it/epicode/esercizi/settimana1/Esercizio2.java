package it.epicode.esercizi.settimana1;

public class Esercizio2 {

	public static void main(String[] args) {
		Sim sim = new Sim("3450320928");
		
		sim.setCreditoDisponibile(20);
		
		Chiamata chiamata = new Chiamata("3496348753", 5);
		
		sim.getListaChiamate()[0] = chiamata;
		
		//nuova istanza
		 chiamata = new Chiamata("3432892573", 3);
			
			sim.getListaChiamate()[1] = chiamata;
	
			sim.stampaDati(); 
	}
}
