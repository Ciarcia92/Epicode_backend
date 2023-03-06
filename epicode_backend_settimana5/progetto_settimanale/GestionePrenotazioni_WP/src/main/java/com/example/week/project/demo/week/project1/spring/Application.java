package com.example.week.project.demo.week.project1.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.week.project.demo.week.project1.spring.DAO.EdificioService;
import com.example.week.project.demo.week.project1.spring.DAO.PostazioneService;
import com.example.week.project.demo.week.project1.spring.DAO.PrenotazioneService;
import com.example.week.project.demo.week.project1.spring.DAO.UtenteService;
import com.example.week.project.demo.week.project1.spring.config.EdificioConfig;
import com.example.week.project.demo.week.project1.spring.config.PostazioneConfig;
import com.example.week.project.demo.week.project1.spring.config.UtenteConfig;
import com.example.week.project.demo.week.project1.spring.entities.Edificio;
import com.example.week.project.demo.week.project1.spring.entities.Postazione;
import com.example.week.project.demo.week.project1.spring.entities.Utente;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

	@Autowired
	PostazioneService ps;
	
	@Autowired
	PrenotazioneService prs;
	
	@Autowired
	UtenteService us;
	
	@Autowired
	EdificioService es;
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(PostazioneConfig.class);
	ApplicationContext ctz = new AnnotationConfigApplicationContext(EdificioConfig.class);
	ApplicationContext ctc = new AnnotationConfigApplicationContext(UtenteConfig.class);
	
	@Override
	public void run(String... args) throws Exception {
	 
		
		Edificio e = (Edificio)ctz.getBean("e1");
		es.insert(e);

		Edificio ed1 = (Edificio)ctz.getBean("e2");
		es.insert(ed1);
		
		Edificio ed2 = (Edificio)ctz.getBean("e3");
		es.insert(ed2);
		
		
		Utente u = (Utente)ctc.getBean("u1");
		us.insert(u);
		
		Utente ut1 = (Utente)ctc.getBean("u2");
		us.insert(ut1);
		
		Utente ut2 = (Utente)ctc.getBean("u3");
		us.insert(ut2);
		
		Postazione p = (Postazione)ctx.getBean("p1");
		p.setEdificio(e);
		ps.insert(p);
		
		Postazione po1 = (Postazione)ctx.getBean("p2");
		po1.setEdificio(ed1);
		ps.insert(po1);
		
		Postazione po2 = (Postazione)ctx.getBean("p3");
		po2.setEdificio(ed2);
		ps.insert(po2);
		
		
		((AnnotationConfigApplicationContext)ctx).close();
		((AnnotationConfigApplicationContext)ctz).close();
		((AnnotationConfigApplicationContext)ctc ).close();
		
	}
	/*
	private void insertEdificio() {
		Edificio e = (Edificio)ctx.getBean("e1");
		es.insert(e);
	}

	private void insertUtente() {
		Utente u = (Utente)ctx.getBean("u1");
		us.insert(u);
	}


	public void insertPostazione() {
		Postazione p = (Postazione)ctx.getBean("p1");
		ps.insert(p);
	}
	*/
}
