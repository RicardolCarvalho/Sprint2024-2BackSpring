package br.insper.entidades.Saude;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaudeRepository extends MongoRepository<Saude, String> {
    Optional<Saude> findByAlunoId(String alunoId);
}
