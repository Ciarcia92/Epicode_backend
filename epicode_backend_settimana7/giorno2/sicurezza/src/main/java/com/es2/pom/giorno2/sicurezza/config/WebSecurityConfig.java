package com.es2.pom.giorno2.sicurezza.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity		// obbligatoria per consentire le PreAuthorize per-metodo
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
		.authorizeRequests()					
			.antMatchers(HttpMethod.GET, "/os/**")
			.permitAll()		
		.and()
		.csrf()
			.disable();
	}
}
