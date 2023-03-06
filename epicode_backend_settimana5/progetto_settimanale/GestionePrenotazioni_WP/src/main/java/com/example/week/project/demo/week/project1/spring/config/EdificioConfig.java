package com.example.week.project.demo.week.project1.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.week.project.demo.week.project1.spring.entities.Edificio;

@Configuration
public class EdificioConfig {

	@Bean
	public Edificio e1() {
		Edificio e1 = Edificio.builder()
				.citta("roma")
				.indirizzo("via piave")
				.nome("building 1")
				.build();
		return e1;
	}
	@Bean
	public Edificio e2() {
		Edificio e2 = Edificio.builder()
				.citta("genova")
				.indirizzo("via ciao")
				.nome("building 2")
				.build();
		return e2;
	}
	@Bean
	public Edificio e3() {
		Edificio e3 = Edificio.builder()
				.citta("aprilia")
				.indirizzo("via lombardia")
				.nome("building 1")
				.build();
		return e3;
	}
}
