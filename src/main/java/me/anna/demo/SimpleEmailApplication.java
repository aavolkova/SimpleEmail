package me.anna.demo;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEmailTools
public class SimpleEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleEmailApplication.class, args);
	}
}
