package es.sprinter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("es.sprinter.repository")

public class ArticuloCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticuloCrudApplication.class, args);
	}

}
