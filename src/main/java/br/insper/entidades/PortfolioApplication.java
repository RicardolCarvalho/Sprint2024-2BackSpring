package br.insper.entidades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		System.out.println("MONGO_URI: " + System.getenv("MONGO_URI"));  // Log da variável de ambiente
		SpringApplication.run(PortfolioApplication.class, args);
	}

}
