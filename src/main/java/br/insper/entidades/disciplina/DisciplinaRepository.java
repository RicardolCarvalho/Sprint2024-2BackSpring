package br.insper.entidades.disciplina;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {
}
