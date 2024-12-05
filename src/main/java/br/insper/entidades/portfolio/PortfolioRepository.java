package br.insper.entidades.portfolio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends MongoRepository<Portfolio, String> {
    List<Portfolio> findByNome(String nome);
}
