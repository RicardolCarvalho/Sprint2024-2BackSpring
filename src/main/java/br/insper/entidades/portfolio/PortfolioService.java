package br.insper.entidades.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    public Portfolio getPortfolioById(String id) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfólio não encontrado para o ID: " + id));

        if (portfolio.getDadosAluno() == null) {
            portfolio.setDadosAluno(Map.of()); // Inicializa vazio se for nulo
        }

        return portfolio;
    }

    public List<Portfolio> findByNome(String nome) {
        return portfolioRepository.findByNome(nome);
    }


    public Portfolio adicionarLaudos(String id, List<String> laudos) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfólio não encontrado para o ID: " + id));

        // Inicializa a lista de laudos, se for nula
        if (portfolio.getLaudos() == null) {
            portfolio.setLaudos(new ArrayList<>());
        }

        // Adiciona os novos laudos à lista existente
        portfolio.getLaudos().addAll(laudos);

        // Salva as alterações no banco
        return portfolioRepository.save(portfolio);
    }

    public Portfolio adicionarObservacoes(String id, List<String> observacoes) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfólio não encontrado para o ID: " + id));
        if (portfolio.getObservacoes() == null) {
            portfolio.setObservacoes(observacoes);
        } else {
            portfolio.getObservacoes().addAll(observacoes);
        }
        return portfolioRepository.save(portfolio);
    }

    public Portfolio removerObservacao(String id, String observacao) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfólio não encontrado para o ID: " + id));

        // Certifique-se de que as observações existem
        if (portfolio.getObservacoes() == null || portfolio.getObservacoes().isEmpty()) {
            throw new RuntimeException("Nenhuma observação encontrada no portfólio");
        }

        // Use trim para remover espaços e normalize para comparação segura
        String normalizedObservacao = observacao.trim();
        boolean removed = portfolio.getObservacoes().removeIf(obs -> obs.trim().equals(normalizedObservacao));

        if (!removed) {
            throw new RuntimeException("Observação não encontrada no portfólio");
        }

        return portfolioRepository.save(portfolio);
    }




    public Portfolio adicionarPerguntas(String id, Map<String, String> novasPerguntas) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfólio não encontrado para o ID: " + id));

        if (portfolio.getPerguntas() == null) {
            portfolio.setPerguntas(new HashMap<>()); // Inicializa o Map se for nulo
        }

        // Adiciona ou atualiza as perguntas no Map existente
        portfolio.getPerguntas().putAll(novasPerguntas);

        return portfolioRepository.save(portfolio);
    }

    public void atualizarNomeAluno(String nomeAntigo, String nomeNovo) {
        // Buscar todos os portfólios que possuem o nomeAntigo
        List<Portfolio> portfolios = portfolioRepository.findByNome(nomeAntigo);
        System.out.println("Atualizando nome no Portfolio: " + nomeAntigo + " para " + nomeNovo);

        for (Portfolio portfolio : portfolios) {
            Map<String, List<Portfolio.Materia>> dadosAluno = portfolio.getDadosAluno();

            // Verificar se o nomeAntigo está presente como chave em dadosAluno
            if (dadosAluno.containsKey(nomeAntigo)) {
                // Remover o registro antigo e colocar o novo
                List<Portfolio.Materia> materias = dadosAluno.remove(nomeAntigo);
                dadosAluno.put(nomeNovo, materias);

                // Atualizar o nome do aluno no portfólio (opcional)
                portfolio.setNome(nomeNovo);

                // Salvar o portfólio atualizado
                portfolioRepository.save(portfolio);
            }
        }
    }

    public void atualizarNomePortfolio(String nomeAntigo, String nomeNovo) {
        List<Portfolio> portfolios = portfolioRepository.findByNome(nomeAntigo);

        if (portfolios.isEmpty()) {
            throw new RuntimeException("Portfólio não encontrado para o nome: " + nomeAntigo);
        }

        for (Portfolio portfolio : portfolios) {
            // Atualiza o nome no portfólio
            portfolio.setNome(nomeNovo);

            // Atualiza a chave no mapa `dadosAluno`
            Map<String, List<Portfolio.Materia>> dadosAluno = portfolio.getDadosAluno();
            if (dadosAluno.containsKey(nomeAntigo)) {
                List<Portfolio.Materia> materias = dadosAluno.remove(nomeAntigo);
                dadosAluno.put(nomeNovo, materias);
            }

            portfolioRepository.save(portfolio);
        }
    }


}
