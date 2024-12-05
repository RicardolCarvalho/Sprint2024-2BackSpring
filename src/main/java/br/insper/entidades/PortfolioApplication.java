package br.insper.entidades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		System.out.println("Iniciando aplicação...");
		System.out.println("Porta definida: " + System.getenv("PORT"));
		SpringApplication.run(PortfolioApplication.class, args);
	}

}
