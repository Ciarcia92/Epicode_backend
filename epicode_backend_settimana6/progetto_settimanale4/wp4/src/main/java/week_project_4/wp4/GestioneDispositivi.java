package week_project_4.wp4;

import java.beans.Beans;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import week_project_4.wp4.config.DispositivoConfig;
import week_project_4.wp4.config.RuoloConfig;
import week_project_4.wp4.config.UtenteConfig;
import week_project_4.wp4.entities.StatoDispositivo;
import week_project_4.wp4.entities.Dispositivo;
import week_project_4.wp4.entities.Ruolo;
import week_project_4.wp4.entities.TipoDispositivo;
import week_project_4.wp4.entities.TipoRuoli;
import week_project_4.wp4.entities.Utente;
import week_project_4.wp4.services.DaoService;

@SpringBootApplication
public class GestioneDispositivi implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GestioneDispositivi.class, args);
	}

	@Autowired
	private DaoService dao;
	
	@Override
	public void run(String... args) throws Exception {

//		popolaDb();
	}

	
	public void popolaDb() {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(UtenteConfig.class);
		ApplicationContext ctz = new AnnotationConfigApplicationContext(RuoloConfig.class);
		ApplicationContext ctc = new AnnotationConfigApplicationContext(DispositivoConfig.class);
			
		Dispositivo d1 = (Dispositivo)ctc.getBean("dispositivo", TipoDispositivo.LAPTOP, StatoDispositivo.ASSEGNATO);
		Dispositivo d2 = (Dispositivo)ctc.getBean("dispositivo", TipoDispositivo.SAMRTPHONE, StatoDispositivo.DISPONIBILE);		
		
		Ruolo r1 = (Ruolo)ctz.getBean("ruolo", TipoRuoli.ROLE_ADMIN);
		Ruolo r2 = (Ruolo)ctz.getBean("ruolo", TipoRuoli.ROLE_USER);
		
		Utente u1 = (Utente)ctx.getBean("utente","tente1","pippo", "email@email.it", "1234");
		Utente u2 = (Utente)ctx.getBean("utente","pluto","plutonium", "ciao@gmail.com", "4567");
		
		u1.setRuoli(new HashSet<>() {{
			add(r1);
			add(r2);
		}});
		
		u1.setDispositivi(new HashSet<>() {{
			add(d1);
		}});
		
		u2.setRuoli(new HashSet<>() {{
			add(r2);
		}});
		
		u1.setDispositivi(new HashSet<>() {{
			add(d2);
		}});
		
		dao.saveDispositivo(d1);
		dao.saveDispositivo(d2);
		dao.salvaRuolo(r2);
		dao.salvaRuolo(r1);
		dao.saveUtente(u1);
		dao.saveUtente(u2);
		
		((AnnotationConfigApplicationContext)ctx).close();
		((AnnotationConfigApplicationContext)ctc).close();
		((AnnotationConfigApplicationContext)ctz).close();
	}
}

