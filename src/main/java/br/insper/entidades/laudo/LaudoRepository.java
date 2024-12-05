package br.insper.entidades.laudo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaudoRepository extends MongoRepository<Laudo, String> {
    Optional<Laudo> findByAlunoId(String alunoId);
    List<Laudo> findAllByAlunoId(String alunoId);
}
