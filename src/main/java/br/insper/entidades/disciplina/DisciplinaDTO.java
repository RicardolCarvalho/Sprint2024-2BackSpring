package br.insper.entidades.disciplina;

record CadastrarDisciplinaDTO(
    String nome,
    Integer alunos
){}

record RetornarDisciplinaDTO(
    String id,
    String nome,
    Integer alunos
){}