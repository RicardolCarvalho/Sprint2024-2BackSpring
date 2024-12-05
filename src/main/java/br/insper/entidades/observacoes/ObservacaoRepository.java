package br.insper.entidades.observacoes;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ObservacaoRepository extends MongoRepository<Observacao, String> {
    Optional<Observacao> findByAlunoId(String alunoId);
}
