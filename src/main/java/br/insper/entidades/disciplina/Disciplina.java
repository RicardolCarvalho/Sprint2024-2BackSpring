package br.insper.entidades.disciplina;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "disciplinas")
public class Disciplina {
    @Id
    private String id;
    private String nome;
    private Integer alunos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAlunos() {
        return alunos;
    }

    public void setAlunos(Integer alunos) {
        this.alunos = alunos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
