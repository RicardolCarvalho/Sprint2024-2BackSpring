package br.insper.entidades.Saude;

record CadastraSaudeDTO(
        String alunoId,
        String problemasFamiliares,
        String acompanhamentoPsicologico,
        String alergicos,
        String cefai,
        String restricaoAlimentar
) {}

record RetornaSaudeDTO(
        String alunoId,
        String problemasFamiliares,
        String acompanhamentoPsicologico,
        String alergicos,
        String cefai,
        String restricaoAlimentar
) {}
