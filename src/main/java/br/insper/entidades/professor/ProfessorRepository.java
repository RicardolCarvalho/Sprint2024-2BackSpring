package br.insper.entidades.professor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends MongoRepository<Professor, String> {
    Page<Professor> findByNomeContaining(String nome, Pageable pageable);
    Page<Professor> findByNomeContainingAndAtivo(String nome, Boolean ativo, Pageable pageable);
    Page<Professor> findByAtivo(Boolean ativo, Pageable pageable);
}
