package week_project_4.wp4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import week_project_4.wp4.entities.Utente;

@Configuration
public class UtenteConfig {
	
	@Bean
	@Scope("prototype")
	public Utente utente(String fullname, String username, String email, String password) {
		Utente utente  = Utente.builder()
				 .fullname(fullname)
				 .username(username)
				 .email(email)
				 .password(password)
				 .build();
		 return utente;
	}

}
