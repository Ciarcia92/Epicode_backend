package it.epicode.progetto.settimana1;

public class Video extends Audio implements Luminosita, Riproducibile {

	int luminosita;

	public Video() {
	}

	
	//METODI
	public void aumentaLuminosita() {
		luminosita++;
	}

	public void diminuisciLuminosita() {
		luminosita--;

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
			System.out.println("la luminosita deve essere maggiore di 0!");
		}

	}
	
	@Override
	public void play() {
		super.play();
		for(int j= 0; j< luminosita; j++) {
			System.out.println("*");
		}
	}

}
