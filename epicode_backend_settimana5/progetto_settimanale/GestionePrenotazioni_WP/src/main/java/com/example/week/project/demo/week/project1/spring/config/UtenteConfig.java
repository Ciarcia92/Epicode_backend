package com.example.week.project.demo.week.project1.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.week.project.demo.week.project1.spring.entities.Utente;

@Configuration
public class UtenteConfig {

	@Bean
	public Utente u1() {
		 Utente u1  = Utente.builder()
				 .email("cicciobello@email.it")
				 .nomeCompleto("lorenzo")
				 .username("azwanagana")
				 .build();
		 return u1;
	}
	@Bean
	public Utente u2() {
		Utente u2  = Utente.builder()
				.email("ciccioo@email.it")
				.nomeCompleto("franco")
				.username("aamericanboy")
				.build();
		return u2;
	}
	@Bean
	public Utente u3() {
		Utente u3  = Utente.builder()
				.email("nello@email.it")
				.nomeCompleto("tizio")
				.username("ciaone")
				.build();
		return u3;
	}
			
}
