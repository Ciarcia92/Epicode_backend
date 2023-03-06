package com.es2.pom.giorno2.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity		// obbligatoria per consentire le PreAuthorize per-metodo
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
		.authorizeRequests()					
			.antMatchers(HttpMethod.GET, "/app/**")
			.permitAll()		
		.and()
		.csrf()
			.disable();
	}
}
