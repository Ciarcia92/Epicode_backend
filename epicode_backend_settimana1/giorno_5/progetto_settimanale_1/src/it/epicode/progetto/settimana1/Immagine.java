package it.epicode.progetto.settimana1;

public class Immagine extends ElementoMultimediale implements Luminosita {

	int luminosita;
	
	public Immagine() {
	
	}

	
	//METODI
	public void show() {
		System.out.println(titolo);
		for(int k = 0; k < luminosita; k++) {
			System.out.println("*");
		}
	}
	@Override
	public int getLuminosita() {
		
		return luminosita;
	}

	@Override
	public void setLuminosita(int luminosita) {
		if (luminosita > 0) {
			this.luminosita = luminosita;
		} else {
			System.out.println("La luminosita deve essere maggiore di 0!");
		}
	}
}
