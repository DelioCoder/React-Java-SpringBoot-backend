 package com.todowebservice.todorestfullwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TodoRestfullWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoRestfullWebServicesApplication.class, args);
	}

	
	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer()
		{
			public void addCorsMappings(CorsRegistry registry)
			{
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://127.0.0.1:5173/");
			}
		};
	}
}
