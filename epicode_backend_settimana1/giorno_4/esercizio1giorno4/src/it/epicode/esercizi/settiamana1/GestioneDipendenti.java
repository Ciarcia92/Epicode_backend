package it.epicode.esercizi.settiamana1;

public class GestioneDipendenti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
		Dipendente dipendente = new Dipendente(69, Dipartimento.AMMINISTRAZIONE, 2500, 15, Livello.DIRIGENTE);
		Dipendente dipendente1 = new Dipendente(23, Dipartimento.PRODUZIONE, 1500, 13, Livello.QUADRO);
		Dipendente dipendente2 = new Dipendente(49, Dipartimento.VENDITE, 2000, 14, Livello.OPERAIO);
		Dipendente dipendente3 = new Dipendente(98, Dipartimento.PRODUZIONE, 1500, 13, Livello.OPERAIO);
		
		Dipendente[] dipendenti = {dipendente, dipendente1, dipendente2, dipendente3};
		
		dipendente.promuovi();
		dipendente2.promuovi();
		dipendente3.promuovi();
	
/*	Dipendente.calcolaPaga(dipendente, 5);
	Dipendente.calcolaPaga(dipendente1, 5);
	Dipendente.calcolaPaga(dipendente3, 5);
	Dipendente.calcolaPaga(dipendente2, 5);
		
	    dipendente.stampaDatiDipendente();
		dipendente1.stampaDatiDipendente();
		dipendente2.stampaDatiDipendente();
		dipendente3.stampaDatiDipendente();
*/	
		
		double totale = 0;
		for(Dipendente d: dipendenti) {
			d.stampaDatiDipendente();
			totale += Dipendente.calcolaPaga(d, 5);
		}
		System.out.println("La somma degli stipendi è: " + totale);
}
	
}
