package com.example.week.project.demo.week.project1.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.week.project.demo.week.project1.spring.entities.Postazione;
import com.example.week.project.demo.week.project1.spring.entities.StatoPostazione;
import com.example.week.project.demo.week.project1.spring.entities.Tipo;


@Configuration
@PropertySource("classpath:application.properties")
public class PostazioneConfig {

//	@Value("${postazioneconfig.o1.descrizione}")
//	private String p1descrizione;

//	in application.resource:#custom data postazioneconfig.p1.descrizione=Postazione semplice

	@Bean
	public Postazione p1() {
		 Postazione p1 = Postazione.builder()
				 .descrizione("postazione semplice")
				 .codice(Postazione.generaCodice())
				 .tipo(Tipo.PRIVATO)
				 .numMaxPartecipanti(10)
				 .statoPostazione(StatoPostazione.LIBERA)
				 
				 .build();
		 return p1;
	}
	@Bean
	public Postazione p2() {
		Postazione p2 = Postazione.builder()
				.descrizione("postazione multipla")
				.codice(Postazione.generaCodice())
				.tipo(Tipo.SALA_RIUNIONI)
				.numMaxPartecipanti(10)
				.statoPostazione(StatoPostazione.LIBERA)
				
				.build();
		return p2;
	}
	@Bean
	public Postazione p3() {
		Postazione p3 = Postazione.builder()
				.descrizione("postazione semplice")
				.codice(Postazione.generaCodice())
				.tipo(Tipo.SPECIALE)
				.numMaxPartecipanti(5)
				.statoPostazione(StatoPostazione.LIBERA)
				
				.build();
		return p3;
	}
	
}
