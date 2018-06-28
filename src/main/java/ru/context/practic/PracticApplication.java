package ru.context.practic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
/**
@param exclude - принимает значение  SecurityAutoConfiguration.class
	для отключения проверки аутентификации на этапе разработки и тестирования приложения
*/
@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class
})
public class PracticApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticApplication.class, args);
	}
}
