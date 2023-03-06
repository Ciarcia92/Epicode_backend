package week_project_4.wp4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import week_project_4.wp4.entities.Ruolo;
import week_project_4.wp4.entities.TipoRuoli;

@Configuration
public class RuoloConfig {

	@Bean
	@Scope("prototype")
	public Ruolo ruolo(TipoRuoli tr) {
		Ruolo ruolo = Ruolo.builder()
				.tipo(tr)
				.build();
		return ruolo;
	}
	
}
