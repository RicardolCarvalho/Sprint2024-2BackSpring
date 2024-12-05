package br.insper.entidades.turma;

import br.insper.entidades.aluno.Aluno;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document (collection = "turmas")
public class Turma {
    @Id
    private String id;
//    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private String ano;
    private String nomeTurma;

    public String getId() {
        return id;
    }

//    public ArrayList<Aluno> getAlunos() {
//        return alunos;
//    }
//
//    public void setAlunos(ArrayList<Aluno> alunos) {
//        this.alunos = alunos;
//    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public void setId(String id) {
        this.id = id;
    }
}
