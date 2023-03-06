package it.epicode.progetto.settimana1;

class Audio extends ElementoMultimediale implements Riproducibile{

	int volume;
    int durata;

    
    
	public Audio() {
	}

	
	//METODI
	public void abbassaVolume() {
		volume--;
	}

	public void alzaVolume() {
		volume++;
	}

	public void play() {
		for(int i = 0; i < durata; i++) {
			System.out.println(titolo);
			for(int x= 0; x < volume; x++) {
				System.out.println("!");
			}
		}
	}
	
	//GETTER
	public int getVolume() {
		return volume;
	}

	//SETTER
	public void setVolume(int volume) {
		if(volume>0) {
			this.volume = volume;
		} else {
			System.out.println("Il volume deve essere maggiore di 0");
			return;
		}
	}
	
	
	@Override
	public int getDurata() {
		return durata;
	}

	@Override
	public void setDurata(int durata) {
		if(durata>0) {
			this.durata = durata;
		} else {
			System.out.println("La durata deve essere maggiore di 0");
			return;
		}
		
	}
}
