package com.stackroute.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableMongoRepositories
public class SpringFinalApplication {
//	@Bean
//	public CorsFilter corsFilter() {
//
//	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	CorsConfiguration config = new CorsConfiguration();
//	config.setAllowCredentials(false); //updated to false
//	config.addAllowedOrigin("*");
//	config.addAllowedHeader("*");
//	config.addAllowedMethod("GET");
//	config.addAllowedMethod("PUT");
//	config.addAllowedMethod("POST");
//	source.registerCorsConfiguration("/**", config);
//	return new CorsFilter(source);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringFinalApplication.class, args);
	}
}
