package br.insper.entidades.professor;

record CadastraProfessorDTO(
        String nome,
        String jornada,
        Boolean acumulo,
        String curricular,
        String turmas,
        String projetos,
        Boolean ativo) {  // Novo campo para status ativo no DTO de cadastro
}

record RetornarProfessorDTO(
        String id,
        String nome,
        Boolean acumulo,
        String jornada,
        String curricular,
        String turmas,
        String projetos,
        Boolean ativo) {  // Novo campo para status ativo no DTO de retorno
}

