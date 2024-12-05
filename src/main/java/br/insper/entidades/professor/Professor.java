package br.insper.entidades.professor;
import br.insper.entidades.turma.Turma;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "professores")
public class Professor {
    @Id
    private String id;
    private String nome;
    private String jornada;
    private Boolean acumulo;
    private String curricular;
    private String turmas;
    private String projetos;
    private Boolean ativo;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getJornada() {
        return jornada;
    }

    public String getCurricular() {
        return curricular;
    }

    public Boolean getAcumulo() {
        return acumulo;
    }

    public String getTurmas() {
        return turmas;
    }

    public String getProjetos() {
        return projetos;
    }

    public Boolean getAtivo() { // Getter para o status ativo
        return ativo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public void setCurricular(String curricular) {
        this.curricular = curricular;
    }

    public void setAcumulo(Boolean acumulo) {
        this.acumulo = acumulo;
    }

    public void setTurmas(String turmas) {
        this.turmas = turmas;
    }

    public void setProjetos(String projetos) {
        this.projetos = projetos;
    }

    public void setAtivo(Boolean ativo) { // Setter para o status ativo
        this.ativo = ativo;
    }
}

