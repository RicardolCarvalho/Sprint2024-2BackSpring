package br.insper.entidades.Saude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaudeService {

    private final SaudeRepository saudeRepository;

    @Autowired
    public SaudeService(SaudeRepository saudeRepository) {
        this.saudeRepository = saudeRepository;
    }


    public void salvarOuAtualizarSaude(String alunoId, Saude saudeAtualizada) {
        // Verificar se já existe um registro de saúde para o aluno
        Saude saudeExistente = saudeRepository.findByAlunoId(alunoId).orElse(null);

        if (saudeExistente != null) {
            // Atualizar os dados existentes
            saudeExistente.setProblemasFamiliares(saudeAtualizada.getProblemasFamiliares());
            saudeExistente.setAcompanhamentoPsicologico(saudeAtualizada.getAcompanhamentoPsicologico());
            saudeExistente.setAlergicos(saudeAtualizada.getAlergicos());
            saudeExistente.setCefai(saudeAtualizada.getCefai());
            saudeExistente.setRestricaoAlimentar(saudeAtualizada.getRestricaoAlimentar());
            saudeRepository.save(saudeExistente);
        } else {
            // Criar um novo registro
            saudeAtualizada.setAlunoId(alunoId);
            saudeRepository.save(saudeAtualizada);
        }
    }

    public Saude getSaude(String alunoId) {
        return saudeRepository.findByAlunoId(alunoId)
                .orElseThrow(() -> new RuntimeException("Nenhuma Saude encontrado para o aluno com ID: " + alunoId));
    }

    public void deletarSaude(String alunoId) {
        Saude saude = saudeRepository.findByAlunoId(alunoId)
                .orElseThrow(() -> new RuntimeException("Nenhuma Saude encontrado com ID: " + alunoId));
        saudeRepository.delete(saude);
    }
}
