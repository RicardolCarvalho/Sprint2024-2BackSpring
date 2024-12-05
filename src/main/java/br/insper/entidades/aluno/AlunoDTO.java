package br.insper.entidades.aluno;

record CadastraAlunoDTO
        (String nome,
         String filiacao1,
         String filiacao2,
         String nomeSocialAluno,
         String nomeAfetivoAluno,
         String dataNascimento,
         String cpf,
         String rg,
         String codigoAluno,
         String codigoInep,
         String turma){

}

record RetornaAlunoDTO
        (String nome,
         String filiacao1,
         String filiacao2,
         String nomeSocialAluno,
         String nomeAfetivoAluno,
         String dataNascimento,
         String cpf,
         String rg,
         String codigoAluno,
         String codigoInep,
         String turma){

}

record EditarAlunoDTO
        (String nome,
         String filiacao1,
         String filiacao2,
         String nomeSocialAluno,
         String nomeAfetivoAluno,
         String dataNascimento,
         String cpf,
         String rg,
         String codigoAluno,
         String codigoInep,
         String turma){

}
