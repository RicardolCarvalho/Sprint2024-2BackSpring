package br.insper.entidades.usuario_gestor;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestorRepository extends MongoRepository<Gestor, String> {
    Gestor findByNome(String nome);
}

