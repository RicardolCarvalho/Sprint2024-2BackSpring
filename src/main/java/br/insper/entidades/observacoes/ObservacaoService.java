package br.insper.entidades.observacoes;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ObservacaoService {

    private final ObservacaoRepository observacaoRepository;

    @Autowired
    public ObservacaoService(ObservacaoRepository observacaoRepository) {
        this.observacaoRepository = observacaoRepository;
    }

    public void salvarObservacao(String alunoId, Observacao observacao) {
        // Configura os dados da observação antes de salvar
        observacao.setAlunoId(alunoId);
        observacaoRepository.save(observacao);
    }

    public Observacao buscarObservacao(String alunoId) {
        return observacaoRepository.findByAlunoId(alunoId)
                .orElseThrow(() -> new RuntimeException("Nenhuma observação encontrada para o aluno com ID: " + alunoId));
    }

    public void atualizarObservacao(String alunoId, Observacao observacaoAtualizada) {
        Observacao observacao = observacaoRepository.findByAlunoId(alunoId)
                .orElseThrow(() -> new RuntimeException("Nenhuma observação encontrada para o aluno com ID: " + alunoId));

        // Atualiza os dados da observação
        observacao.setObservacao(observacaoAtualizada.getObservacao());
        observacaoRepository.save(observacao);
    }

    public void deletarObservacao(String id) {
        Observacao observacao = observacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhuma observação encontrada com ID: " + id));
        observacaoRepository.delete(observacao);
    }
}
