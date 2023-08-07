package com.eazybytes.eazybankrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true) // Not recommended for production
public class EazybankrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazybankrestapiApplication.class, args);
	}

}
