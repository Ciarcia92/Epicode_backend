package it.epicode.rilevamento_incendi.application;

import it.epicode.rilevamento_incendi.application.models.CanaleDiComunicazione;
import it.epicode.rilevamento_incendi.application.models.CentroControllo;
import it.epicode.rilevamento_incendi.application.models.MioCanaleDiComunicazione;
import it.epicode.rilevamento_incendi.application.models.Sonda;

public class Main {

	public static void main(String[] args) {
		
		CanaleDiComunicazione canale = (CanaleDiComunicazione) new MioCanaleDiComunicazione();

        CentroControllo centroControllo = CentroControllo.getInstance(canale);

        Sonda sonda1 = new Sonda(1, 50.98, 7.1900, 0.0, canale);
        Sonda sonda2 = new Sonda(2, 35.75, 8.2252, 0.0, canale);
        centroControllo.addSonda(sonda1);
        centroControllo.addSonda(sonda2);

        sonda1.setSmokeLevel(7.5);

        sonda2.setSmokeLevel(5.0);
        
        sonda2.setSmokeLevel(7);
        
        sonda1.setSmokeLevel(7);
	}

}
