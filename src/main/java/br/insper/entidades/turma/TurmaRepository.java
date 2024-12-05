package br.insper.entidades.turma;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends MongoRepository<Turma, String> {
    Turma findByNomeTurma(String nomeTurma);
    List<Turma> findByAno(String ano);
    Turma findByNomeTurmaStartingWith(String prefixo);
}
