package br.insper.entidades.turma;

import br.insper.entidades.aluno.Aluno;

import java.util.ArrayList;

record CadastraTurmaDTO
        (ArrayList<String> alunos, String anoTurma, String nomeTurma){
}

record RetornarTurmaDTO
        (ArrayList<Aluno> alunos, Turma turma){
}
record RetornarTurmaEdicaoDTO
        (Turma turma){

}
record EditarTurmaDTO(String anoTurma, String nomeTurma){

}