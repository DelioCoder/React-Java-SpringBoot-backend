package com.todowebservice.todorestfullwebservices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuratio
public class BasicAuthenticationSecurityConfiguration {

	// Filter chain
	// Authenticate all request
	// Basic Authentication
	// Disabling CSRF
	// Stateless rest api
	
	// 1: Response to preflight request doesn't pass access control check
	// 2: basic auth
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		return http.authorizeHttpRequests(
				auth -> auth
						.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
						.anyRequest().authenticated()
		)
		
		.httpBasic(Customizer.withDefaults())
		
		.sessionManagement(
				session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		)
		
		.csrf(csrf -> csrf.disable()).build();
	}
	
}
