package week_project_4.wp4.security;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import week_project_4.wp4.entities.Ruolo;
import week_project_4.wp4.entities.Utente;
import week_project_4.wp4.services.DaoService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DaoService dao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	
		http
			.authorizeRequests()					
				.antMatchers("/", "/page1")
				.permitAll()
			.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.successForwardUrl("/login_success")
			.and()
			.logout()
			.and()
			.csrf()
				.disable();
	}
	

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	Optional <Utente> authUserObj= dao.getUtenteById(1);
	Utente authUtente  = authUserObj.get();
	String ruolo = "UTENTE";
	Set<Ruolo> ruoli = authUtente .getRuoli();
	
	 for(Ruolo r : ruoli) {
		 if(r.getTipo().toString().contains("ADMIN")) {
			 ruolo = "ADMIN";
			 break;
		 }
	 }
	 
		auth.inMemoryAuthentication()
		.withUser( authUtente.getUsername() ).password( passwordEncoder().encode( authUtente.getPassword() ) )
		.roles(ruolo);
	}
	 
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
	