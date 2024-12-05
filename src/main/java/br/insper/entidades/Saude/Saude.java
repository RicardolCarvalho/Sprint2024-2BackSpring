package br.insper.entidades.Saude;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "saude")
public class Saude {

    @Id
    private String id;
    private String alunoId;
    private String problemasFamiliares;
    private String acompanhamentoPsicologico;
    private String alergicos;
    private String cefai;
    private String restricaoAlimentar;

    // Getters and Setters
    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlunoId() { return alunoId; }

    public void setAlunoId(String alunoId) {
        this.alunoId = alunoId;
    }

    public String getProblemasFamiliares() { return problemasFamiliares; }

    public void setProblemasFamiliares(String problemasFamiliares) { this.problemasFamiliares = problemasFamiliares; }

    public String getAcompanhamentoPsicologico() { return acompanhamentoPsicologico; }

    public void setAcompanhamentoPsicologico(String acompanhamentoPsicologico) { this.acompanhamentoPsicologico = acompanhamentoPsicologico; }

    public String getAlergicos() { return alergicos; }

    public void setAlergicos(String alergicos) { this.alergicos = alergicos; }

    public String getCefai() { return cefai; }

    public void setCefai(String cefai) { this.cefai = cefai; }

    public String getRestricaoAlimentar() { return restricaoAlimentar; }

    public void setRestricaoAlimentar(String restricaoAlimentar) { this.restricaoAlimentar = restricaoAlimentar; }
}