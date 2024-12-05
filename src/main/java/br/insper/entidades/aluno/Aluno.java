package br.insper.entidades.aluno;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "alunos")
public class Aluno {
    @Id
    private String id;
    private String nome;
    private String filiacao1;
    private String filiacao2;
    private String nomeSocialAluno;
    private String nomeAfetivoAluno;
    private String dataNascimento;
    private String cpf;
    private String rg;
    private String codigoAluno;
    private String codigoInep;
    private String turma;

    public String getFiliacao1() {
        return filiacao1;
    }

    public void setFiliacao1(String filiacao1) {
        this.filiacao1 = filiacao1;
    }

    public String getFiliacao2() {
        return filiacao2;
    }

    public void setFiliacao2(String filiacao2) {
        this.filiacao2 = filiacao2;
    }

    public String getNomeSocialAluno() {
        return nomeSocialAluno;
    }

    public void setNomeSocialAluno(String nomeSocialAluno) {
        this.nomeSocialAluno = nomeSocialAluno;
    }

    public String getNomeAfetivoAluno() {
        return nomeAfetivoAluno;
    }

    public void setNomeAfetivoAluno(String nomeAfetivoAluno) {
        this.nomeAfetivoAluno = nomeAfetivoAluno;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(String codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getCodigoInep() {
        return codigoInep;
    }

    public void setCodigoInep(String codigoInep) {
        this.codigoInep = codigoInep;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}

