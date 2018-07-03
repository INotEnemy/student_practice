package ru.context.practic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class PracticApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticApplication.class, args);
	}
}
