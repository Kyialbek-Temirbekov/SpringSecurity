package com.eazybytes.eazybankrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//MLS
@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class EazybankrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazybankrestapiApplication.class, args);
	}

}
