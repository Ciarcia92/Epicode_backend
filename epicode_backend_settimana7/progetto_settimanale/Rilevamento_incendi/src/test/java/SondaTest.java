package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.epicode.rilevamento_incendi.application.models.CanaleDiComunicazione;
import it.epicode.rilevamento_incendi.application.models.MioCanaleDiComunicazione;
import it.epicode.rilevamento_incendi.application.models.Sonda;


public class SondaTest {

	private Sonda sonda;
    CanaleDiComunicazione canale = (CanaleDiComunicazione) new MioCanaleDiComunicazione();

	@Before
	public void setUp() {
		sonda = new Sonda(1, 35.0, 8.0, 0.0, canale);
	}

	@Test
	public void testSetSmokeLevel() {
		
		sonda.setSmokeLevel(2.8);
		assertEquals(2.8, sonda.getSmokeLevel(), 0.0);

		sonda.setSmokeLevel(6.0);
		assertEquals(6.0, sonda.getSmokeLevel(), 0.0);
	}
}
