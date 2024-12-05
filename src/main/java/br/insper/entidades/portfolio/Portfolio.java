package br.insper.entidades.portfolio;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "portfolio")
public class Portfolio {

    @Id
    private String id;
    private String nome;
    private Map<String, List<Materia>> dadosAluno;
    private List<String> laudos;
    private List<String> observacoes;
    private Map<String, String> perguntas; // Atualizado para refletir o novo formato no MongoDB

    public Portfolio() {}

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

    public Map<String, List<Materia>> getDadosAluno() {
        return dadosAluno;
    }

    public void setDadosAluno(Map<String, List<Materia>> dadosAluno) {
        this.dadosAluno = dadosAluno;
    }

    public List<String> getLaudos() {
        return laudos;
    }

    public void setLaudos(List<String> laudos) {
        this.laudos = laudos;
    }

    public List<String> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<String> observacoes) {
        this.observacoes = observacoes;
    }

    public Map<String, String> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(Map<String, String> perguntas) {
        this.perguntas = perguntas;
    }

    public static class Materia {
        private String materia;
        private String anoTurma;
        private Map<String, Object> notas;

        public Materia() {}

        public String getMateria() {
            return materia;
        }

        public void setMateria(String materia) {
            this.materia = materia;
        }

        public String getAnoTurma() {
            return anoTurma;
        }

        public void setAnoTurma(String anoTurma) {
            this.anoTurma = anoTurma;
        }

        public Map<String, Object> getNotas() {
            return notas;
        }

        public void setNotas(Map<String, Object> notas) {
            this.notas = notas;
        }
    }
}
