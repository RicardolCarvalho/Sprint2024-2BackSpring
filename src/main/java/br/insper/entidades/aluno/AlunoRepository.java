package br.insper.entidades.aluno;

import br.insper.entidades.turma.Turma;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {
    Aluno findByNome(String Nome);
    Aluno findByCpf(String cpf);
    List<Aluno> findByTurma(String nomeTurma);
    Aluno findByNomeStartingWith(String prefixo);
}
